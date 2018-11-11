package com.pons.bridge.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.6.0.
 */
public class EscrowERC20 extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b50600080543361010002600160a860020a03199091161790556102f8806100386000396000f3006080604052600436106100615763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416636a8f21dc8114610066578063886ed6b41461008f578063e7e647b114610100578063fe15d4ef14610123575b600080fd5b34801561007257600080fd5b5061007b610138565b604080519115158252519081900360200190f35b34801561009b57600080fd5b50604080516020600460443581810135601f810184900484028501840190955284845261007b948235600160a060020a039081169560248035909216953695946064949293019190819084018382808284375094975050933594506101419350505050565b34801561010c57600080fd5b50610121600160a060020a03600435166101c4565b005b34801561012f57600080fd5b5061007b6101f9565b60005460ff1681565b600080546101009004600160a060020a03163314156101b85760018054600160a060020a0380881673ffffffffffffffffffffffffffffffffffffffff1992831617909255600280549287169290911691909117905582516101aa906003906020860190610234565b5050600481905560016101bc565b5060005b949350505050565b6000546101009004600160a060020a03163314156101f65760005460ff16156101f35780600160a060020a0316ff5b33ff5b50565b600080546101009004600160a060020a031633141561022d57506000805460ff19811660ff91821615179182905516610231565b5060005b90565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061027557805160ff19168380011785556102a2565b828001600101855582156102a2579182015b828111156102a2578251825591602001919060010190610287565b506102ae9291506102b2565b5090565b61023191905b808211156102ae57600081556001016102b85600a165627a7a723058209d6bcad4124bc25364829ca6c30ff5142f2d65f369d1da4db15532b0d2dd85730029";

    public static final String FUNC_CANFREE = "canFree";

    public static final String FUNC_SETPARAMS = "setParams";

    public static final String FUNC_FREEFROMESCROW = "freeFromEscrow";

    public static final String FUNC_SWITCHBOOL = "switchBool";

    @Deprecated
    protected EscrowERC20(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected EscrowERC20(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected EscrowERC20(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected EscrowERC20(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<Boolean> canFree() {
        final Function function = new Function(FUNC_CANFREE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> setParams(String _from, String _to, String _passcode, BigInteger quantity) {
        final Function function = new Function(
                FUNC_SETPARAMS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_from), 
                new org.web3j.abi.datatypes.Address(_to), 
                new org.web3j.abi.datatypes.Utf8String(_passcode), 
                new org.web3j.abi.datatypes.generated.Uint256(quantity)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> freeFromEscrow(String _to) {
        final Function function = new Function(
                FUNC_FREEFROMESCROW, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_to)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> switchBool() {
        final Function function = new Function(
                FUNC_SWITCHBOOL, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<EscrowERC20> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(EscrowERC20.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<EscrowERC20> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(EscrowERC20.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<EscrowERC20> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(EscrowERC20.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<EscrowERC20> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(EscrowERC20.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static EscrowERC20 load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new EscrowERC20(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static EscrowERC20 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new EscrowERC20(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static EscrowERC20 load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new EscrowERC20(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static EscrowERC20 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new EscrowERC20(contractAddress, web3j, transactionManager, contractGasProvider);
    }
}
