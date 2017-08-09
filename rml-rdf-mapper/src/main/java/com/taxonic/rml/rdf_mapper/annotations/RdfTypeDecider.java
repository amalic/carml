package com.taxonic.rml.rdf_mapper.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface RdfTypeDecider {
	Class<?> value();
}