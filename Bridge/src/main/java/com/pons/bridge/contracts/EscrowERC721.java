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
    private static final String BINARY = "608060405234801561001057600080fd5b5060008054600160a060020a03191633179055610468806100326000396000f3006080604052600436106100565763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416630ad2571f81146100585780633412a15c146100e0578063886ed6b4146100f5575b005b34801561006457600080fd5b5060408051602060046024803582810135601f81018590048502860185019096528585526100cc95833573ffffffffffffffffffffffffffffffffffffffff169536956044949193909101919081908401838280828437509497506101739650505050505050565b604080519115158252519081900360200190f35b3480156100ec57600080fd5b506100cc6102e2565b34801561010157600080fd5b50604080516020600460443581810135601f81018490048402850184019095528484526100cc94823573ffffffffffffffffffffffffffffffffffffffff9081169560248035909216953695946064949293019190819084018382808284375094975050933594506102e89350505050565b6003805460408051602060026001851615610100026000190190941693909304601f810184900484028201840190925281815260009361020c93919290918301828280156102025780601f106101d757610100808354040283529160200191610202565b820191906000526020600020905b8154815290600101906020018083116101e557829003601f168201915b5050505050610380565b61021583610380565b14156102d857604080517f7472616e736665725f746f6b656e2875696e743235362c206164647265737329815281519081900360200181206004805460025463ffffffff7c01000000000000000000000000000000000000000000000000000000009485900490811690940285529184015273ffffffffffffffffffffffffffffffffffffffff90811660248401529251928616929091604480820192600092909190829003018183875af19250505015156102d057600080fd5b5060016102dc565b5060005b92915050565b60015b90565b6000805473ffffffffffffffffffffffffffffffffffffffff16331415610374576001805473ffffffffffffffffffffffffffffffffffffffff80881673ffffffffffffffffffffffffffffffffffffffff1992831617909255600280549287169290911691909117905582516103669060039060208601906103a4565b505060048190556001610378565b5060005b949350505050565b805160009082901515610396576000915061039e565b602083015191505b50919050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106103e557805160ff1916838001178555610412565b82800160010185558215610412579182015b828111156104125782518255916020019190600101906103f7565b5061041e929150610422565b5090565b6102e591905b8082111561041e57600081556001016104285600a165627a7a72305820344e0a3930a2b17566ce4b54e66853e7a3549d8487b25bdb800861f4fb4a5b2d0029";

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
