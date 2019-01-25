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
public class EscrowERC721 extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b5060008054600160a060020a03191633179055610479806100326000396000f30060806040526004361061004b5763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416630ad2571f811461004d578063886ed6b4146100d5575b005b34801561005957600080fd5b5060408051602060046024803582810135601f81018590048502860185019096528585526100c195833573ffffffffffffffffffffffffffffffffffffffff169536956044949193909101919081908401838280828437509497506101539650505050505050565b604080519115158252519081900360200190f35b3480156100e157600080fd5b50604080516020600460443581810135601f81018490048402850184019095528484526100c194823573ffffffffffffffffffffffffffffffffffffffff9081169560248035909216953695946064949293019190819084018382808284375094975050933594506102f69350505050565b6003805460408051602060026001851615610100026000190190941693909304601f81018490048402820184019092528181526000936101ec93919290918301828280156101e25780601f106101b7576101008083540402835291602001916101e2565b820191906000526020600020905b8154815290600101906020018083116101c557829003601f168201915b505050505061038e565b6101f58361038e565b14156102ec57604080517f7472616e7366657246726f6d28616464726573732c616464726573732c75696e81527f7432353629000000000000000000000000000000000000000000000000000000602082015281519081900360250181206001546002546004805463ffffffff7c010000000000000000000000000000000000000000000000000000000095869004908116909502865273ffffffffffffffffffffffffffffffffffffffff93841691860191909152908216602485015260448401529251928616929091606480820192600092909190829003018183875af19250505015156102e457600080fd5b5060016102f0565b5060005b92915050565b6000805473ffffffffffffffffffffffffffffffffffffffff16331415610382576001805473ffffffffffffffffffffffffffffffffffffffff80881673ffffffffffffffffffffffffffffffffffffffff1992831617909255600280549287169290911691909117905582516103749060039060208601906103b2565b505060048190556001610386565b5060005b949350505050565b8051600090829015156103a457600091506103ac565b602083015191505b50919050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106103f357805160ff1916838001178555610420565b82800160010185558215610420579182015b82811115610420578251825591602001919060010190610405565b5061042c929150610430565b5090565b61044a91905b8082111561042c5760008155600101610436565b905600a165627a7a72305820705200cd307da315fd4d694f5950c3488455b37257f736ecbc84e34dd16d7a550029";

    public static final String FUNC_FREEFROMESCROW = "freeFromEscrow";

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
}
