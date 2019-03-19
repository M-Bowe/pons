package com.pons.bridge.web3j;

import java.math.BigInteger;

import org.web3j.tx.Contract;
import org.web3j.tx.gas.StaticGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;

public class DeployGasProvider extends StaticGasProvider {

	public static final BigInteger GAS_LIMIT = new BigInteger("100_000_000");//DefaultGasProvider.GAS_LIMIT;
  public static final BigInteger GAS_PRICE = new BigInteger("0");

	public DeployGasProvider() {
		super(GAS_PRICE, GAS_LIMIT);
	}

}
