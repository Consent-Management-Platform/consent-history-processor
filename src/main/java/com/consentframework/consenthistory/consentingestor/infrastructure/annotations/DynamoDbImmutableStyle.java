package com.consentframework.consenthistory.consentingestor.infrastructure.annotations;

import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Style;
import software.amazon.awssdk.enhanced.dynamodb.extensions.annotations.DynamoDbAtomicCounter;
import software.amazon.awssdk.enhanced.dynamodb.extensions.annotations.DynamoDbAutoGeneratedTimestampAttribute;
import software.amazon.awssdk.enhanced.dynamodb.extensions.annotations.DynamoDbVersionAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbConvertedBy;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbFlatten;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbIgnore;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbIgnoreNulls;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbImmutable;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPreserveEmptyObject;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSecondaryPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSecondarySortKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbUpdateBehavior;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Immutable style for DynamoDB table mapping classes.
 *
 * Ref: https://immutables.github.io/dynamodb.html
 */
@Retention(RetentionPolicy.CLASS)
@Style(
    // Omit add(*) methods so they aren't interpreted as table attributes
    builtinContainerAttributes = false,
    // Omit copy(*) methods so they aren't interpreted as table attributes
    defaults = @Immutable(copy = false),
    // Omit from(*) methods so they aren't interpreted as table attributes
    from = "",
    // Copy all Enhanced Client annotations to the immutable class
    passAnnotations = {
        DynamoDbAtomicCounter.class,
        DynamoDbAttribute.class,
        DynamoDbAutoGeneratedTimestampAttribute.class,
        DynamoDbConvertedBy.class,
        DynamoDbFlatten.class,
        DynamoDbIgnore.class,
        DynamoDbIgnoreNulls.class,
        DynamoDbImmutable.class,
        DynamoDbPartitionKey.class,
        DynamoDbPreserveEmptyObject.class,
        DynamoDbSecondaryPartitionKey.class,
        DynamoDbSecondarySortKey.class,
        DynamoDbSortKey.class,
        DynamoDbUpdateBehavior.class,
        DynamoDbVersionAttribute.class,
    },
    // Enable strict builder mode to prevent initialization errors
    strictBuilder = true,
    // Have Builder return original class instead of implementation
    overshadowImplementation = true
)
@Target({ ElementType.PACKAGE, ElementType.TYPE })
public @interface DynamoDbImmutableStyle {
}
