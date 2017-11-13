package com.miage.RepertoireWebApp.factory.impl;

import com.miage.RepertoireWebApp.entity.Carnet;
import com.miage.RepertoireWebApp.factory.ICarnetFactory;

public class CarnetFactory implements ICarnetFactory {

	public Carnet createCarnet(String idCarnet) {
		return new Carnet(Integer.valueOf(idCarnet).intValue());
	}

}
