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
public class PaymentCreatedAvroModel extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -6092037281516279553L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"PaymentCreatedAvroModel\",\"namespace\":\"multiwarehouse.ecommerce.payment.avro.model\",\"fields\":[{\"name\":\"paymentId\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"referenceId\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"amount\",\"type\":{\"type\":\"bytes\",\"logicalType\":\"decimal\",\"precision\":10,\"scale\":2}},{\"name\":\"createdAt\",\"type\":{\"type\":\"long\",\"logicalType\":\"timestamp-millis\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();
  static {
    MODEL$.addLogicalTypeConversion(new org.apache.avro.data.TimeConversions.TimestampMillisConversion());
    MODEL$.addLogicalTypeConversion(new org.apache.avro.Conversions.DecimalConversion());
  }

  private static final BinaryMessageEncoder<PaymentCreatedAvroModel> ENCODER =
      new BinaryMessageEncoder<PaymentCreatedAvroModel>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<PaymentCreatedAvroModel> DECODER =
      new BinaryMessageDecoder<PaymentCreatedAvroModel>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<PaymentCreatedAvroModel> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<PaymentCreatedAvroModel> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<PaymentCreatedAvroModel> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<PaymentCreatedAvroModel>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this PaymentCreatedAvroModel to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a PaymentCreatedAvroModel from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a PaymentCreatedAvroModel instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static PaymentCreatedAvroModel fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.String paymentId;
  private java.lang.String referenceId;
  private java.math.BigDecimal amount;
  private java.time.Instant createdAt;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public PaymentCreatedAvroModel() {}

  /**
   * All-args constructor.
   * @param paymentId The new value for paymentId
   * @param referenceId The new value for referenceId
   * @param amount The new value for amount
   * @param createdAt The new value for createdAt
   */
  public PaymentCreatedAvroModel(java.lang.String paymentId, java.lang.String referenceId, java.math.BigDecimal amount, java.time.Instant createdAt) {
    this.paymentId = paymentId;
    this.referenceId = referenceId;
    this.amount = amount;
    this.createdAt = createdAt.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return paymentId;
    case 1: return referenceId;
    case 2: return amount;
    case 3: return createdAt;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  private static final org.apache.avro.Conversion<?>[] conversions =
      new org.apache.avro.Conversion<?>[] {
      null,
      null,
      new org.apache.avro.Conversions.DecimalConversion(),
      new org.apache.avro.data.TimeConversions.TimestampMillisConversion(),
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
    case 0: paymentId = value$ != null ? value$.toString() : null; break;
    case 1: referenceId = value$ != null ? value$.toString() : null; break;
    case 2: amount = (java.math.BigDecimal)value$; break;
    case 3: createdAt = (java.time.Instant)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'paymentId' field.
   * @return The value of the 'paymentId' field.
   */
  public java.lang.String getPaymentId() {
    return paymentId;
  }


  /**
   * Sets the value of the 'paymentId' field.
   * @param value the value to set.
   */
  public void setPaymentId(java.lang.String value) {
    this.paymentId = value;
  }

  /**
   * Gets the value of the 'referenceId' field.
   * @return The value of the 'referenceId' field.
   */
  public java.lang.String getReferenceId() {
    return referenceId;
  }


  /**
   * Sets the value of the 'referenceId' field.
   * @param value the value to set.
   */
  public void setReferenceId(java.lang.String value) {
    this.referenceId = value;
  }

  /**
   * Gets the value of the 'amount' field.
   * @return The value of the 'amount' field.
   */
  public java.math.BigDecimal getAmount() {
    return amount;
  }


  /**
   * Sets the value of the 'amount' field.
   * @param value the value to set.
   */
  public void setAmount(java.math.BigDecimal value) {
    this.amount = value;
  }

  /**
   * Gets the value of the 'createdAt' field.
   * @return The value of the 'createdAt' field.
   */
  public java.time.Instant getCreatedAt() {
    return createdAt;
  }


  /**
   * Sets the value of the 'createdAt' field.
   * @param value the value to set.
   */
  public void setCreatedAt(java.time.Instant value) {
    this.createdAt = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
  }

  /**
   * Creates a new PaymentCreatedAvroModel RecordBuilder.
   * @return A new PaymentCreatedAvroModel RecordBuilder
   */
  public static multiwarehouse.ecommerce.payment.avro.model.PaymentCreatedAvroModel.Builder newBuilder() {
    return new multiwarehouse.ecommerce.payment.avro.model.PaymentCreatedAvroModel.Builder();
  }

  /**
   * Creates a new PaymentCreatedAvroModel RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new PaymentCreatedAvroModel RecordBuilder
   */
  public static multiwarehouse.ecommerce.payment.avro.model.PaymentCreatedAvroModel.Builder newBuilder(multiwarehouse.ecommerce.payment.avro.model.PaymentCreatedAvroModel.Builder other) {
    if (other == null) {
      return new multiwarehouse.ecommerce.payment.avro.model.PaymentCreatedAvroModel.Builder();
    } else {
      return new multiwarehouse.ecommerce.payment.avro.model.PaymentCreatedAvroModel.Builder(other);
    }
  }

  /**
   * Creates a new PaymentCreatedAvroModel RecordBuilder by copying an existing PaymentCreatedAvroModel instance.
   * @param other The existing instance to copy.
   * @return A new PaymentCreatedAvroModel RecordBuilder
   */
  public static multiwarehouse.ecommerce.payment.avro.model.PaymentCreatedAvroModel.Builder newBuilder(multiwarehouse.ecommerce.payment.avro.model.PaymentCreatedAvroModel other) {
    if (other == null) {
      return new multiwarehouse.ecommerce.payment.avro.model.PaymentCreatedAvroModel.Builder();
    } else {
      return new multiwarehouse.ecommerce.payment.avro.model.PaymentCreatedAvroModel.Builder(other);
    }
  }

  /**
   * RecordBuilder for PaymentCreatedAvroModel instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<PaymentCreatedAvroModel>
    implements org.apache.avro.data.RecordBuilder<PaymentCreatedAvroModel> {

    private java.lang.String paymentId;
    private java.lang.String referenceId;
    private java.math.BigDecimal amount;
    private java.time.Instant createdAt;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(multiwarehouse.ecommerce.payment.avro.model.PaymentCreatedAvroModel.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.paymentId)) {
        this.paymentId = data().deepCopy(fields()[0].schema(), other.paymentId);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.referenceId)) {
        this.referenceId = data().deepCopy(fields()[1].schema(), other.referenceId);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.amount)) {
        this.amount = data().deepCopy(fields()[2].schema(), other.amount);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.createdAt)) {
        this.createdAt = data().deepCopy(fields()[3].schema(), other.createdAt);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
    }

    /**
     * Creates a Builder by copying an existing PaymentCreatedAvroModel instance
     * @param other The existing instance to copy.
     */
    private Builder(multiwarehouse.ecommerce.payment.avro.model.PaymentCreatedAvroModel other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.paymentId)) {
        this.paymentId = data().deepCopy(fields()[0].schema(), other.paymentId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.referenceId)) {
        this.referenceId = data().deepCopy(fields()[1].schema(), other.referenceId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.amount)) {
        this.amount = data().deepCopy(fields()[2].schema(), other.amount);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.createdAt)) {
        this.createdAt = data().deepCopy(fields()[3].schema(), other.createdAt);
        fieldSetFlags()[3] = true;
      }
    }

    /**
      * Gets the value of the 'paymentId' field.
      * @return The value.
      */
    public java.lang.String getPaymentId() {
      return paymentId;
    }


    /**
      * Sets the value of the 'paymentId' field.
      * @param value The value of 'paymentId'.
      * @return This builder.
      */
    public multiwarehouse.ecommerce.payment.avro.model.PaymentCreatedAvroModel.Builder setPaymentId(java.lang.String value) {
      validate(fields()[0], value);
      this.paymentId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'paymentId' field has been set.
      * @return True if the 'paymentId' field has been set, false otherwise.
      */
    public boolean hasPaymentId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'paymentId' field.
      * @return This builder.
      */
    public multiwarehouse.ecommerce.payment.avro.model.PaymentCreatedAvroModel.Builder clearPaymentId() {
      paymentId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'referenceId' field.
      * @return The value.
      */
    public java.lang.String getReferenceId() {
      return referenceId;
    }


    /**
      * Sets the value of the 'referenceId' field.
      * @param value The value of 'referenceId'.
      * @return This builder.
      */
    public multiwarehouse.ecommerce.payment.avro.model.PaymentCreatedAvroModel.Builder setReferenceId(java.lang.String value) {
      validate(fields()[1], value);
      this.referenceId = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'referenceId' field has been set.
      * @return True if the 'referenceId' field has been set, false otherwise.
      */
    public boolean hasReferenceId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'referenceId' field.
      * @return This builder.
      */
    public multiwarehouse.ecommerce.payment.avro.model.PaymentCreatedAvroModel.Builder clearReferenceId() {
      referenceId = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'amount' field.
      * @return The value.
      */
    public java.math.BigDecimal getAmount() {
      return amount;
    }


    /**
      * Sets the value of the 'amount' field.
      * @param value The value of 'amount'.
      * @return This builder.
      */
    public multiwarehouse.ecommerce.payment.avro.model.PaymentCreatedAvroModel.Builder setAmount(java.math.BigDecimal value) {
      validate(fields()[2], value);
      this.amount = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'amount' field has been set.
      * @return True if the 'amount' field has been set, false otherwise.
      */
    public boolean hasAmount() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'amount' field.
      * @return This builder.
      */
    public multiwarehouse.ecommerce.payment.avro.model.PaymentCreatedAvroModel.Builder clearAmount() {
      amount = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'createdAt' field.
      * @return The value.
      */
    public java.time.Instant getCreatedAt() {
      return createdAt;
    }


    /**
      * Sets the value of the 'createdAt' field.
      * @param value The value of 'createdAt'.
      * @return This builder.
      */
    public multiwarehouse.ecommerce.payment.avro.model.PaymentCreatedAvroModel.Builder setCreatedAt(java.time.Instant value) {
      validate(fields()[3], value);
      this.createdAt = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'createdAt' field has been set.
      * @return True if the 'createdAt' field has been set, false otherwise.
      */
    public boolean hasCreatedAt() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'createdAt' field.
      * @return This builder.
      */
    public multiwarehouse.ecommerce.payment.avro.model.PaymentCreatedAvroModel.Builder clearCreatedAt() {
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public PaymentCreatedAvroModel build() {
      try {
        PaymentCreatedAvroModel record = new PaymentCreatedAvroModel();
        record.paymentId = fieldSetFlags()[0] ? this.paymentId : (java.lang.String) defaultValue(fields()[0]);
        record.referenceId = fieldSetFlags()[1] ? this.referenceId : (java.lang.String) defaultValue(fields()[1]);
        record.amount = fieldSetFlags()[2] ? this.amount : (java.math.BigDecimal) defaultValue(fields()[2]);
        record.createdAt = fieldSetFlags()[3] ? this.createdAt : (java.time.Instant) defaultValue(fields()[3]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<PaymentCreatedAvroModel>
    WRITER$ = (org.apache.avro.io.DatumWriter<PaymentCreatedAvroModel>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<PaymentCreatedAvroModel>
    READER$ = (org.apache.avro.io.DatumReader<PaymentCreatedAvroModel>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}










