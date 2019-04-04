package com.pons.bridge.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
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
public class EscrowERC20 extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b5060008054600160a060020a031916331790556104ef806100326000396000f3006080604052600436106100775763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416630ad2571f811461007957806371492685146100f4578063798fd17814610125578063886ed6b41461013a578063ae0113d1146101ab578063d321fe29146101cc575b005b34801561008557600080fd5b5060408051602060046024803582810135601f81018590048502860185019096528585526100e0958335600160a060020a03169536956044949193909101919081908401838280828437509497506101f39650505050505050565b604080519115158252519081900360200190f35b34801561010057600080fd5b50610109610358565b60408051600160a060020a039092168252519081900360200190f35b34801561013157600080fd5b50610109610368565b34801561014657600080fd5b50604080516020600460443581810135601f81018490048402850184019095528484526100e0948235600160a060020a039081169560248035909216953695946064949293019190819084018382808284375094975050933594506103779350505050565b3480156101b757600080fd5b50610077600160a060020a03600435166103f5565b3480156101d857600080fd5b506101e1610401565b60408051918252519081900360200190f35b6003805460408051602060026001851615610100026000190190941693909304601f810184900484028201840190925281815260009361028c93919290918301828280156102825780601f1061025757610100808354040283529160200191610282565b820191906000526020600020905b81548152906001019060200180831161026557829003601f168201915b5050505050610407565b61029583610407565b141561034e57604080517f7472616e7366657228616464726573732c75696e743235362900000000000000815281519081900360190181206002546004805463ffffffff7c0100000000000000000000000000000000000000000000000000000000948590049081169094028552600160a060020a039283169185019190915260248401529251928616929091604480820192600092909190829003018183875af192505050151561034657600080fd5b506001610352565b5060005b92915050565b600254600160a060020a03165b90565b600154600160a060020a031690565b60008054600160a060020a03163314156103e95760018054600160a060020a0380881673ffffffffffffffffffffffffffffffffffffffff1992831617909255600280549287169290911691909117905582516103db90600390602086019061042b565b5050600481905560016103ed565b5060005b949350505050565b80600160a060020a0316ff5b60045490565b80516000908290151561041d5760009150610425565b602083015191505b50919050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061046c57805160ff1916838001178555610499565b82800160010185558215610499579182015b8281111561049957825182559160200191906001019061047e565b506104a59291506104a9565b5090565b61036591905b808211156104a557600081556001016104af5600a165627a7a723058208ec2145a7798dd348001900220114036076c14746442801efaffaf8526835c530029";

    public static final String FUNC_FREEFROMESCROW = "freeFromEscrow";

    public static final String FUNC_GETTO = "getTo";

    public static final String FUNC_GETFROM = "getFrom";

    public static final String FUNC_SETPARAMS = "setParams";

    public static final String FUNC_TESTSD = "testSD";

    public static final String FUNC_GETAMOUNT = "getAmount";

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

    public RemoteCall<TransactionReceipt> freeFromEscrow(String _existingContract, String _pass) {
        final Function function = new Function(
                FUNC_FREEFROMESCROW, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_existingContract), 
                new org.web3j.abi.datatypes.Utf8String(_pass)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> getTo() {
        final Function function = new Function(FUNC_GETTO, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> getFrom() {
        final Function function = new Function(FUNC_GETFROM, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
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

    public RemoteCall<BigInteger> getAmount() {
        final Function function = new Function(FUNC_GETAMOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
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
}
