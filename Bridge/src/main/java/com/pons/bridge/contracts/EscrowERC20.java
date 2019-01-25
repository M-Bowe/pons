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
    private static final String BINARY = "608060405234801561001057600080fd5b5060008054600160a060020a0319163317905561043f806100326000396000f3006080604052600436106100565763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416630ad2571f8114610058578063886ed6b4146100d3578063ae0113d114610144575b005b34801561006457600080fd5b5060408051602060046024803582810135601f81018590048502860185019096528585526100bf958335600160a060020a03169536956044949193909101919081908401838280828437509497506101659650505050505050565b604080519115158252519081900360200190f35b3480156100df57600080fd5b50604080516020600460443581810135601f81018490048402850184019095528484526100bf948235600160a060020a039081169560248035909216953695946064949293019190819084018382808284375094975050933594506102ca9350505050565b34801561015057600080fd5b50610056600160a060020a0360043516610348565b6003805460408051602060026001851615610100026000190190941693909304601f81018490048402820184019092528181526000936101fe93919290918301828280156101f45780601f106101c9576101008083540402835291602001916101f4565b820191906000526020600020905b8154815290600101906020018083116101d757829003601f168201915b5050505050610354565b61020783610354565b14156102c057604080517f7472616e7366657228616464726573732c75696e743235362900000000000000815281519081900360190181206002546004805463ffffffff7c0100000000000000000000000000000000000000000000000000000000948590049081169094028552600160a060020a039283169185019190915260248401529251928616929091604480820192600092909190829003018183875af19250505015156102b857600080fd5b5060016102c4565b5060005b92915050565b60008054600160a060020a031633141561033c5760018054600160a060020a0380881673ffffffffffffffffffffffffffffffffffffffff19928316179092556002805492871692909116919091179055825161032e906003906020860190610378565b505060048190556001610340565b5060005b949350505050565b80600160a060020a0316ff5b80516000908290151561036a5760009150610372565b602083015191505b50919050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106103b957805160ff19168380011785556103e6565b828001600101855582156103e6579182015b828111156103e65782518255916020019190600101906103cb565b506103f29291506103f6565b5090565b61041091905b808211156103f257600081556001016103fc565b905600a165627a7a72305820405b70bec6ee96eeb6956cae8769ddbcbf77c14d118210a6718cda1279c10f230029";

    public static final String FUNC_FREEFROMESCROW = "freeFromEscrow";

    public static final String FUNC_SETPARAMS = "setParams";

    public static final String FUNC_TESTSD = "testSD";

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
