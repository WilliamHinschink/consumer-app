package com.sibentek.consumer.ws.validator;

import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.MarshalException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.transform.Source;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * Validates the XML streams going in the request and response if the log level
 * is {@link Level#FINER} or below against {@value #LOGGER_NAME}. If
 * {@link Level#FINEST} is used it will also dump the XML that were sent.
 *
 * @author Archimedes Trajano
 *
 */
public class XmlValidationInterceptor {
  /**
   * Logger.
   */
  private static final Logger LOG;

  /**
   * Name of the logger.
   */
  public static final String LOGGER_NAME = "xml.validation"; //$NON-NLS-1$

  static {
    LOG = Logger.getLogger(LOGGER_NAME, "Messages"); //$NON-NLS-1$
  }

  /**
   * Contains a composite of multiple schema files into one schema that used
   * on all message validations.
   */
  private final Schema schema;

  /**
   * Loads up the schema into memory. This uses the default
   *
   * @throws SAXException
   *             problem parsing the schema files.
   */
  public XmlValidationInterceptor() throws SAXException {
    final SchemaFactory sf = SchemaFactory
        .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    schema = sf.newSchema();
  }

  /**
   * Loads up the schema from the specified array of {@link Source} into
   * memory.
   *
   * @param schemaSources
   *            schema sources.
   * @throws SAXException
   *             problem parsing the schema files.
   */
  public XmlValidationInterceptor(final Source... schemaSources)
      throws SAXException {
    final SchemaFactory sf = SchemaFactory
        .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    schema = sf.newSchema(schemaSources);
  }

  /**
   * Writes the object as XML to the logger.
   *
   * @param param
   *            object to marshal
   * @param context
   *            invocation context used for logging.
   * @throws JAXBException
   *             problem with the Java binding except schema issues because
   *             schema validation errors are caught and processed
   *             differently.
   */
  private void marshalObject(final Object param,
      final InvocationContext context) throws JAXBException {
    if (!param.getClass().isAnnotationPresent(XmlRootElement.class)) {
      return;
    }

    // validate against known schemas
    final JAXBContext jaxbContext = JAXBContext.newInstance(param
        .getClass());
    final Marshaller m = jaxbContext.createMarshaller();
    m.setSchema(schema);
    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    try {
      final StringWriter w = new StringWriter();
      m.marshal(param, w);
      LOG.finest(w.toString());
    } catch (final MarshalException e) {
      if (!(e.getLinkedException() instanceof SAXParseException)) {
        throw e;
      }
      final SAXParseException parseException = (SAXParseException) e
          .getLinkedException();
      LOG.log(Level.SEVERE,
          "XmlValidationInterceptor.parseException", // $NON-NLS-1$
          new Object[] { context.getMethod(), param,
              parseException.getMessage() });
      m.setSchema(null);
      final StringWriter w = new StringWriter();
      m.marshal(param, w);
      LOG.finest(w.toString());
    }
  }

  /**
   * Validates the data in the parameters and return values.
   *
   * @param context
   *            invocation context
   * @return invocation return value
   * @throws Exception
   *             invocation exception
   */
  @AroundInvoke
  public Object validate(final InvocationContext context) throws Exception {
    if (!LOG.isLoggable(Level.FINER)) {
      return context.proceed();
    }

    final Object[] params = context.getParameters();
    for (final Object param : params) {
      marshalObject(param, context);
    }

    final Object ret = context.proceed();
    if (ret != null) {
      marshalObject(ret, context);
    }
    return ret;
  }

}
