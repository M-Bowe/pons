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
 * <p>Generated with web3j version 4.0.1.
 */
public class EscrowERC721 extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b5060008054600160a060020a0319163317905561067e806100326000396000f3006080604052600436106100535763ffffffff60e060020a6000350416630ad2571f8114610055578063150b7a02146100d05780633412a15c1461013e5780636b83420c14610153578063886ed6b4146101bc575b005b34801561006157600080fd5b5060408051602060046024803582810135601f81018590048502860185019096528585526100bc958335600160a060020a031695369560449491939091019190819084018382808284375094975061022d9650505050505050565b604080519115158252519081900360200190f35b3480156100dc57600080fd5b50610109600160a060020a0360048035821691602480359091169160443591606435908101910135610376565b604080517fffffffff000000000000000000000000000000000000000000000000000000009092168252519081900360200190f35b34801561014a57600080fd5b506100bc6103d7565b34801561015f57600080fd5b5060408051602060046024803582810135601f81018590048502860185019096528585526100bc958335600160a060020a031695369560449491939091019190819084018382808284375094975050933594506103dd9350505050565b3480156101c857600080fd5b50604080516020600460443581810135601f81018490048402850184019095528484526100bc948235600160a060020a039081169560248035909216953695946064949293019190819084018382808284375094975050933594506105189350505050565b6003805460408051602060026001851615610100026000190190941693909304601f81018490048402820184019092528181526000936102c693919290918301828280156102bc5780601f10610291576101008083540402835291602001916102bc565b820191906000526020600020905b81548152906001019060200180831161029f57829003601f168201915b5050505050610596565b6102cf83610596565b141561036c57604080517f7472616e736665725f746f6b656e2875696e743235362c6164647265737329008152815190819003601f0181206004805460025463ffffffff60e060020a94859004908116909402855291840152600160a060020a0390811660248401529251928616929091604480820192600092909190829003018183875af192505050151561036457600080fd5b506001610370565b5060005b92915050565b604080517f6f6e455243373231526563656976656428616464726573732c6164647265737381527f2c75696e743235362c62797465732900000000000000000000000000000000006020820152905190819003602f01902095945050505050565b60015b90565b600083600160a060020a031660405180807f6372656174654c6f616e28737472696e672c616464726573732c75696e74323581526020017f36290000000000000000000000000000000000000000000000000000000000008152506022019050604051809103902060e060020a900484600260009054906101000a9004600160a060020a0316856040518463ffffffff1660e060020a02815260040180848051906020019080838360005b838110156104a0578181015183820152602001610488565b50505050905090810190601f1680156104cd5780820380516001836020036101000a031916815260200191505b5083600160a060020a0316600160a060020a0316815260200182815260200193505050506000604051808303816000875af192505050151561050e57600080fd5b5060019392505050565b60008054600160a060020a031633141561058a5760018054600160a060020a0380881673ffffffffffffffffffffffffffffffffffffffff19928316179092556002805492871692909116919091179055825161057c9060039060208601906105ba565b50506004819055600161058e565b5060005b949350505050565b8051600090829015156105ac57600091506105b4565b602083015191505b50919050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106105fb57805160ff1916838001178555610628565b82800160010185558215610628579182015b8281111561062857825182559160200191906001019061060d565b50610634929150610638565b5090565b6103da91905b80821115610634576000815560010161063e5600a165627a7a723058201e37f427d958d713dc3e7cbca0aaa95e57877b52e017700cb9c0d876705f9d610029";

    public static final String FUNC_FREEFROMESCROW = "freeFromEscrow";

    public static final String FUNC_TESTCONNECTION = "testConnection";

    public static final String FUNC_SETPARAMS = "setParams";

    @Deprecated
    protected EscrowERC721(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected EscrowERC721(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected EscrowERC721(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected EscrowERC721(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> freeFromEscrow(String _existingContract, String _pass) {
        final Function function = new Function(
                FUNC_FREEFROMESCROW,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_existingContract),
                new org.web3j.abi.datatypes.Utf8String(_pass)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> testConnection() {
        final Function function = new Function(
                FUNC_TESTCONNECTION,
                Arrays.<Type>asList(),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setParams(String _from, String _to, String _passcode, BigInteger _id) {
        final Function function = new Function(
                FUNC_SETPARAMS,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_from),
                new org.web3j.abi.datatypes.Address(_to),
                new org.web3j.abi.datatypes.Utf8String(_passcode),
                new org.web3j.abi.datatypes.generated.Uint256(_id)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static EscrowERC721 load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new EscrowERC721(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static EscrowERC721 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new EscrowERC721(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static EscrowERC721 load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new EscrowERC721(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static EscrowERC721 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new EscrowERC721(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<EscrowERC721> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(EscrowERC721.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<EscrowERC721> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(EscrowERC721.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<EscrowERC721> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(EscrowERC721.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<EscrowERC721> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(EscrowERC721.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
