package com.svyatobatko.dimploma.models;

import com.svyatobatko.dimploma.models.Type;

public enum Type {
	Wedding_tour, Extreme_tour, Individua_tours;

	public static int getTypeIndex(Type type) {
		return type.ordinal();
	}

	public static Type getTypeById(int typeID) {

		switch (typeID) {
		case 1:
			return Type.Wedding_tour;
		case 2:
			return Type.Extreme_tour;
		case 3:
			return Type.Individua_tours;
		}
		return null;

	}
}