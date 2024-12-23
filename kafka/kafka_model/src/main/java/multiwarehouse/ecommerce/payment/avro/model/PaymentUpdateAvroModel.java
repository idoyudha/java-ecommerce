/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package multiwarehouse.ecommerce.payment.avro.model;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class PaymentUpdateAvroModel extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 1481960898044587532L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"PaymentUpdateAvroModel\",\"namespace\":\"multiwarehouse.ecommerce.payment.avro.model\",\"fields\":[{\"name\":\"id\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"payment_id\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"reference_id\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"paymentStatus\",\"type\":{\"type\":\"enum\",\"name\":\"PaymentStatus\",\"symbols\":[\"ONPROCESS\",\"SUCCESS\",\"FAILED\"]}},{\"name\":\"failedMessage\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<PaymentUpdateAvroModel> ENCODER =
      new BinaryMessageEncoder<PaymentUpdateAvroModel>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<PaymentUpdateAvroModel> DECODER =
      new BinaryMessageDecoder<PaymentUpdateAvroModel>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<PaymentUpdateAvroModel> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<PaymentUpdateAvroModel> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<PaymentUpdateAvroModel> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<PaymentUpdateAvroModel>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this PaymentUpdateAvroModel to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a PaymentUpdateAvroModel from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a PaymentUpdateAvroModel instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static PaymentUpdateAvroModel fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.String id;
  private java.lang.String payment_id;
  private java.lang.String reference_id;
  private multiwarehouse.ecommerce.payment.avro.model.PaymentStatus paymentStatus;
  private java.lang.String failedMessage;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public PaymentUpdateAvroModel() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param payment_id The new value for payment_id
   * @param reference_id The new value for reference_id
   * @param paymentStatus The new value for paymentStatus
   * @param failedMessage The new value for failedMessage
   */
  public PaymentUpdateAvroModel(java.lang.String id, java.lang.String payment_id, java.lang.String reference_id, multiwarehouse.ecommerce.payment.avro.model.PaymentStatus paymentStatus, java.lang.String failedMessage) {
    this.id = id;
    this.payment_id = payment_id;
    this.reference_id = reference_id;
    this.paymentStatus = paymentStatus;
    this.failedMessage = failedMessage;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return payment_id;
    case 2: return reference_id;
    case 3: return paymentStatus;
    case 4: return failedMessage;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  private static final org.apache.avro.Conversion<?>[] conversions =
      new org.apache.avro.Conversion<?>[] {
      null,
      null,
      null,
      null,
      null,
      null
  };

  @Override
  public org.apache.avro.Conversion<?> getConversion(int field) {
    return conversions[field];
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = value$ != null ? value$.toString() : null; break;
    case 1: payment_id = value$ != null ? value$.toString() : null; break;
    case 2: reference_id = value$ != null ? value$.toString() : null; break;
    case 3: paymentStatus = (multiwarehouse.ecommerce.payment.avro.model.PaymentStatus)value$; break;
    case 4: failedMessage = value$ != null ? value$.toString() : null; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public java.lang.String getId() {
    return id;
  }


  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.String value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'payment_id' field.
   * @return The value of the 'payment_id' field.
   */
  public java.lang.String getPaymentId() {
    return payment_id;
  }


  /**
   * Sets the value of the 'payment_id' field.
   * @param value the value to set.
   */
  public void setPaymentId(java.lang.String value) {
    this.payment_id = value;
  }

  /**
   * Gets the value of the 'reference_id' field.
   * @return The value of the 'reference_id' field.
   */
  public java.lang.String getReferenceId() {
    return reference_id;
  }


  /**
   * Sets the value of the 'reference_id' field.
   * @param value the value to set.
   */
  public void setReferenceId(java.lang.String value) {
    this.reference_id = value;
  }

  /**
   * Gets the value of the 'paymentStatus' field.
   * @return The value of the 'paymentStatus' field.
   */
  public multiwarehouse.ecommerce.payment.avro.model.PaymentStatus getPaymentStatus() {
    return paymentStatus;
  }


  /**
   * Sets the value of the 'paymentStatus' field.
   * @param value the value to set.
   */
  public void setPaymentStatus(multiwarehouse.ecommerce.payment.avro.model.PaymentStatus value) {
    this.paymentStatus = value;
  }

  /**
   * Gets the value of the 'failedMessage' field.
   * @return The value of the 'failedMessage' field.
   */
  public java.lang.String getFailedMessage() {
    return failedMessage;
  }


  /**
   * Sets the value of the 'failedMessage' field.
   * @param value the value to set.
   */
  public void setFailedMessage(java.lang.String value) {
    this.failedMessage = value;
  }

  /**
   * Creates a new PaymentUpdateAvroModel RecordBuilder.
   * @return A new PaymentUpdateAvroModel RecordBuilder
   */
  public static multiwarehouse.ecommerce.payment.avro.model.PaymentUpdateAvroModel.Builder newBuilder() {
    return new multiwarehouse.ecommerce.payment.avro.model.PaymentUpdateAvroModel.Builder();
  }

  /**
   * Creates a new PaymentUpdateAvroModel RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new PaymentUpdateAvroModel RecordBuilder
   */
  public static multiwarehouse.ecommerce.payment.avro.model.PaymentUpdateAvroModel.Builder newBuilder(multiwarehouse.ecommerce.payment.avro.model.PaymentUpdateAvroModel.Builder other) {
    if (other == null) {
      return new multiwarehouse.ecommerce.payment.avro.model.PaymentUpdateAvroModel.Builder();
    } else {
      return new multiwarehouse.ecommerce.payment.avro.model.PaymentUpdateAvroModel.Builder(other);
    }
  }

  /**
   * Creates a new PaymentUpdateAvroModel RecordBuilder by copying an existing PaymentUpdateAvroModel instance.
   * @param other The existing instance to copy.
   * @return A new PaymentUpdateAvroModel RecordBuilder
   */
  public static multiwarehouse.ecommerce.payment.avro.model.PaymentUpdateAvroModel.Builder newBuilder(multiwarehouse.ecommerce.payment.avro.model.PaymentUpdateAvroModel other) {
    if (other == null) {
      return new multiwarehouse.ecommerce.payment.avro.model.PaymentUpdateAvroModel.Builder();
    } else {
      return new multiwarehouse.ecommerce.payment.avro.model.PaymentUpdateAvroModel.Builder(other);
    }
  }

  /**
   * RecordBuilder for PaymentUpdateAvroModel instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<PaymentUpdateAvroModel>
    implements org.apache.avro.data.RecordBuilder<PaymentUpdateAvroModel> {

    private java.lang.String id;
    private java.lang.String payment_id;
    private java.lang.String reference_id;
    private multiwarehouse.ecommerce.payment.avro.model.PaymentStatus paymentStatus;
    private java.lang.String failedMessage;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(multiwarehouse.ecommerce.payment.avro.model.PaymentUpdateAvroModel.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.payment_id)) {
        this.payment_id = data().deepCopy(fields()[1].schema(), other.payment_id);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.reference_id)) {
        this.reference_id = data().deepCopy(fields()[2].schema(), other.reference_id);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.paymentStatus)) {
        this.paymentStatus = data().deepCopy(fields()[3].schema(), other.paymentStatus);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.failedMessage)) {
        this.failedMessage = data().deepCopy(fields()[4].schema(), other.failedMessage);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
    }

    /**
     * Creates a Builder by copying an existing PaymentUpdateAvroModel instance
     * @param other The existing instance to copy.
     */
    private Builder(multiwarehouse.ecommerce.payment.avro.model.PaymentUpdateAvroModel other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.payment_id)) {
        this.payment_id = data().deepCopy(fields()[1].schema(), other.payment_id);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.reference_id)) {
        this.reference_id = data().deepCopy(fields()[2].schema(), other.reference_id);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.paymentStatus)) {
        this.paymentStatus = data().deepCopy(fields()[3].schema(), other.paymentStatus);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.failedMessage)) {
        this.failedMessage = data().deepCopy(fields()[4].schema(), other.failedMessage);
        fieldSetFlags()[4] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public java.lang.String getId() {
      return id;
    }


    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public multiwarehouse.ecommerce.payment.avro.model.PaymentUpdateAvroModel.Builder setId(java.lang.String value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public multiwarehouse.ecommerce.payment.avro.model.PaymentUpdateAvroModel.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'payment_id' field.
      * @return The value.
      */
    public java.lang.String getPaymentId() {
      return payment_id;
    }


    /**
      * Sets the value of the 'payment_id' field.
      * @param value The value of 'payment_id'.
      * @return This builder.
      */
    public multiwarehouse.ecommerce.payment.avro.model.PaymentUpdateAvroModel.Builder setPaymentId(java.lang.String value) {
      validate(fields()[1], value);
      this.payment_id = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'payment_id' field has been set.
      * @return True if the 'payment_id' field has been set, false otherwise.
      */
    public boolean hasPaymentId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'payment_id' field.
      * @return This builder.
      */
    public multiwarehouse.ecommerce.payment.avro.model.PaymentUpdateAvroModel.Builder clearPaymentId() {
      payment_id = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'reference_id' field.
      * @return The value.
      */
    public java.lang.String getReferenceId() {
      return reference_id;
    }


    /**
      * Sets the value of the 'reference_id' field.
      * @param value The value of 'reference_id'.
      * @return This builder.
      */
    public multiwarehouse.ecommerce.payment.avro.model.PaymentUpdateAvroModel.Builder setReferenceId(java.lang.String value) {
      validate(fields()[2], value);
      this.reference_id = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'reference_id' field has been set.
      * @return True if the 'reference_id' field has been set, false otherwise.
      */
    public boolean hasReferenceId() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'reference_id' field.
      * @return This builder.
      */
    public multiwarehouse.ecommerce.payment.avro.model.PaymentUpdateAvroModel.Builder clearReferenceId() {
      reference_id = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'paymentStatus' field.
      * @return The value.
      */
    public multiwarehouse.ecommerce.payment.avro.model.PaymentStatus getPaymentStatus() {
      return paymentStatus;
    }


    /**
      * Sets the value of the 'paymentStatus' field.
      * @param value The value of 'paymentStatus'.
      * @return This builder.
      */
    public multiwarehouse.ecommerce.payment.avro.model.PaymentUpdateAvroModel.Builder setPaymentStatus(multiwarehouse.ecommerce.payment.avro.model.PaymentStatus value) {
      validate(fields()[3], value);
      this.paymentStatus = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'paymentStatus' field has been set.
      * @return True if the 'paymentStatus' field has been set, false otherwise.
      */
    public boolean hasPaymentStatus() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'paymentStatus' field.
      * @return This builder.
      */
    public multiwarehouse.ecommerce.payment.avro.model.PaymentUpdateAvroModel.Builder clearPaymentStatus() {
      paymentStatus = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'failedMessage' field.
      * @return The value.
      */
    public java.lang.String getFailedMessage() {
      return failedMessage;
    }


    /**
      * Sets the value of the 'failedMessage' field.
      * @param value The value of 'failedMessage'.
      * @return This builder.
      */
    public multiwarehouse.ecommerce.payment.avro.model.PaymentUpdateAvroModel.Builder setFailedMessage(java.lang.String value) {
      validate(fields()[4], value);
      this.failedMessage = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'failedMessage' field has been set.
      * @return True if the 'failedMessage' field has been set, false otherwise.
      */
    public boolean hasFailedMessage() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'failedMessage' field.
      * @return This builder.
      */
    public multiwarehouse.ecommerce.payment.avro.model.PaymentUpdateAvroModel.Builder clearFailedMessage() {
      failedMessage = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public PaymentUpdateAvroModel build() {
      try {
        PaymentUpdateAvroModel record = new PaymentUpdateAvroModel();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.String) defaultValue(fields()[0]);
        record.payment_id = fieldSetFlags()[1] ? this.payment_id : (java.lang.String) defaultValue(fields()[1]);
        record.reference_id = fieldSetFlags()[2] ? this.reference_id : (java.lang.String) defaultValue(fields()[2]);
        record.paymentStatus = fieldSetFlags()[3] ? this.paymentStatus : (multiwarehouse.ecommerce.payment.avro.model.PaymentStatus) defaultValue(fields()[3]);
        record.failedMessage = fieldSetFlags()[4] ? this.failedMessage : (java.lang.String) defaultValue(fields()[4]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<PaymentUpdateAvroModel>
    WRITER$ = (org.apache.avro.io.DatumWriter<PaymentUpdateAvroModel>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<PaymentUpdateAvroModel>
    READER$ = (org.apache.avro.io.DatumReader<PaymentUpdateAvroModel>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}










