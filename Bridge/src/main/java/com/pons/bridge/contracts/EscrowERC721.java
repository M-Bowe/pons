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
    private static final String BINARY = "608060405234801561001057600080fd5b5060008054600160a060020a03191633179055610445806100326000396000f30060806040526004361061004b5763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416630ad2571f811461004d578063886ed6b4146100d5575b005b34801561005957600080fd5b5060408051602060046024803582810135601f81018590048502860185019096528585526100c195833573ffffffffffffffffffffffffffffffffffffffff169536956044949193909101919081908401838280828437509497506101539650505050505050565b604080519115158252519081900360200190f35b3480156100e157600080fd5b50604080516020600460443581810135601f81018490048402850184019095528484526100c194823573ffffffffffffffffffffffffffffffffffffffff9081169560248035909216953695946064949293019190819084018382808284375094975050933594506102c29350505050565b6003805460408051602060026001851615610100026000190190941693909304601f81018490048402820184019092528181526000936101ec93919290918301828280156101e25780601f106101b7576101008083540402835291602001916101e2565b820191906000526020600020905b8154815290600101906020018083116101c557829003601f168201915b505050505061035a565b6101f58361035a565b14156102b857604080517f7472616e736665725f746f6b656e2875696e743235362c206164647265737329815281519081900360200181206004805460025463ffffffff7c01000000000000000000000000000000000000000000000000000000009485900490811690940285529184015273ffffffffffffffffffffffffffffffffffffffff90811660248401529251928616929091604480820192600092909190829003018183875af19250505015156102b057600080fd5b5060016102bc565b5060005b92915050565b6000805473ffffffffffffffffffffffffffffffffffffffff1633141561034e576001805473ffffffffffffffffffffffffffffffffffffffff80881673ffffffffffffffffffffffffffffffffffffffff19928316179092556002805492871692909116919091179055825161034090600390602086019061037e565b505060048190556001610352565b5060005b949350505050565b8051600090829015156103705760009150610378565b602083015191505b50919050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106103bf57805160ff19168380011785556103ec565b828001600101855582156103ec579182015b828111156103ec5782518255916020019190600101906103d1565b506103f89291506103fc565b5090565b61041691905b808211156103f85760008155600101610402565b905600a165627a7a7230582068aa35b9f613c44ac2d78b854ea0011c3c7a94ba7f329071aec3a97764384ea40029";

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
