package com.pons.bridge.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
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
    private static final String BINARY = "608060405234801561001057600080fd5b5060008054600160a060020a03191633179055610390806100326000396000f3006080604052600436106100565763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663886ed6b48114610058578063ae0113d1146100dd578063eafc1006146100fe575b005b34801561006457600080fd5b50604080516020600460443581810135601f81018490048402850184019095528484526100c9948235600160a060020a039081169560248035909216953695946064949293019190819084018382808284375094975050933594506101579350505050565b604080519115158252519081900360200190f35b3480156100e957600080fd5b50610056600160a060020a03600435166101d5565b34801561010a57600080fd5b506040805160206004803580820135601f81018490048402850184019095528484526100c99436949293602493928401919081908401838280828437509497506101e19650505050505050565b60008054600160a060020a03163314156101c95760018054600160a060020a0380881673ffffffffffffffffffffffffffffffffffffffff1992831617909255600280549287169290911691909117905582516101bb9060039060208601906102c9565b5050600481905560016101cd565b5060005b949350505050565b80600160a060020a0316ff5b60006101ec826102a5565b60038054604080516020601f6002610100600187161502600019019095169490940493840181900481028201810190925282815261028393909290918301828280156102795780601f1061024e57610100808354040283529160200191610279565b820191906000526020600020905b81548152906001019060200180831161025c57829003601f168201915b50505050506102a5565b141561029757600254600160a060020a0316ff5b600154600160a060020a0316ff5b8051600090829015156102bb57600091506102c3565b602083015191505b50919050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061030a57805160ff1916838001178555610337565b82800160010185558215610337579182015b8281111561033757825182559160200191906001019061031c565b50610343929150610347565b5090565b61036191905b80821115610343576000815560010161034d565b905600a165627a7a72305820e59385a341bb7f15c89d27c38681053bb65a38fb85528c0aadee2bc03b4116790029";

    public static final String FUNC_SETPARAMS = "setParams";

    public static final String FUNC_TESTSD = "testSD";

    public static final String FUNC_FREEFROMESCROW = "freeFromEscrow";

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

    public RemoteCall<TransactionReceipt> testSD(String _ad) {
        final Function function = new Function(
                FUNC_TESTSD, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_ad)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> freeFromEscrow(String _passcode) {
        final Function function = new Function(
                FUNC_FREEFROMESCROW, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_passcode)), 
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
