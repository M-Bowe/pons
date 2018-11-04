package com.pons.bridge.web3j;

import java.math.BigInteger;

import org.web3j.tx.Contract;
import org.web3j.tx.gas.StaticGasProvider;

public class DeployGasProvider extends StaticGasProvider {
	
	public static final BigInteger GAS_LIMIT = Contract.GAS_LIMIT;
    public static final BigInteger GAS_PRICE = new BigInteger("0");

	public DeployGasProvider() {
		super(GAS_PRICE, GAS_LIMIT);
	}
	
}
