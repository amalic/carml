package com.taxonic.carml.model.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Value;

import com.taxonic.carml.model.GraphMap;
import com.taxonic.carml.model.SubjectMap;
import com.taxonic.carml.model.TermType;
import com.taxonic.carml.model.TriplesMap;
import com.taxonic.carml.rdf_mapper.annotations.RdfProperty;
import com.taxonic.carml.rdf_mapper.annotations.RdfType;
import com.taxonic.carml.vocab.Rr;

public class CarmlSubjectMap extends CarmlTermMap implements SubjectMap {

	private Set<IRI> classes;
	private Set<GraphMap> graphMaps;

	public CarmlSubjectMap() {}
	
	public CarmlSubjectMap(
		String reference,
		String inverseExpression,
		String template,
		TermType termType,
		Value constant,
		TriplesMap functionValue,
		Set<IRI> classes,
		Set<GraphMap> graphMaps
	) {
		super(reference, inverseExpression, template, termType, constant, functionValue);
		this.classes = classes;
		this.graphMaps = graphMaps;
	}

	
	@RdfProperty(Rr.graphMap)
	@RdfType(CarmlGraphMap.class)
	@Override
	public Set<GraphMap> getGraphMaps() {
		return graphMaps;
	}
	
	public void setGraphMaps(Set<GraphMap> graphMaps) {
		this.graphMaps = graphMaps;
	}
	
	@RdfProperty(Rr.clazz)
	@Override
	public Set<IRI> getClasses() {
		return classes;
	}

	public void setClasses(Set<IRI> classes) {
		this.classes = classes;
	}

	@Override
	public String toString() {
		return "CarmlSubjectMap [getGraphMaps()=" + getGraphMaps() + ", getClasses()=" + getClasses()
			+ ", getReference()=" + getReference() + ", getInverseExpression()=" + getInverseExpression()
			+ ", getTemplate()=" + getTemplate() + ", getTermType()=" + getTermType() + ", getConstant()="
			+ getConstant() + ", getFunctionValue()=" + getFunctionValue() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((classes == null) ? 0 : classes.hashCode());
		result = prime * result + ((graphMaps == null) ? 0 : graphMaps.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!super.equals(obj)) return false;
		if (getClass() != obj.getClass()) return false;
		CarmlSubjectMap other = (CarmlSubjectMap) obj;
		if (classes == null) {
			if (other.classes != null) return false;
		}
		else if (!classes.equals(other.classes)) return false;
		if (graphMaps == null) {
			if (other.graphMaps != null) return false;
		}
		else if (!graphMaps.equals(other.graphMaps)) return false;
		return true;
	}

	public static Builder newBuilder() {
		return new Builder();
	}
	
	public static class Builder
		extends CarmlTermMap.Builder {
		
		private Set<IRI> classes = new LinkedHashSet<>();
		private Set<GraphMap> graphMaps = new LinkedHashSet<>();

		public Builder reference(String reference) {
			super.reference(reference);
			return this;
		}
		
		public Builder inverseExpression(String inverseExpression) {
			super.inverseExpression(inverseExpression);
			return this;
		}
		
		public Builder template(String template) {
			super.template(template);
			return this;
		}
		
		public Builder termType(TermType termType) {
			super.termType(termType);
			return this;
		}
		
		public Builder constant(Value constant) {
			super.constant(constant);
			return this;
		}
		
		public Builder functionValue(TriplesMap functionValue) {
			super.functionValue(functionValue);
			return this;
		}
		
		public Builder clazz(IRI clazz) {
			classes.add(clazz);
			return this;
		}
		
		public Builder classes(Set<IRI> classes) {
			this.classes = classes;
			return this;
		}
		
		public Builder graphMap(CarmlGraphMap carmlGraphMap) {
			graphMaps.add(carmlGraphMap);
			return this;
		}
		
		public Builder graphMaps(Set<GraphMap> graphMaps) {
			this.graphMaps= graphMaps;
			return this;
		}
		
		public CarmlSubjectMap build() {
			return new CarmlSubjectMap(
				getReference(),
				getInverseExpression(),
				getTemplate(),
				getTermType(),
				getConstant(),
				getFunctionValue(),
				classes,
				graphMaps
			);
		}
	}
}
