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
    private static final String BINARY = "608060405234801561001057600080fd5b5060008054600160a060020a031916331790556105a4806100326000396000f3006080604052600436106100485763ffffffff60e060020a6000350416630ad2571f811461004a5780633412a15c146100c55780636b83420c146100da578063886ed6b414610143575b005b34801561005657600080fd5b5060408051602060046024803582810135601f81018590048502860185019096528585526100b1958335600160a060020a03169536956044949193909101919081908401838280828437509497506101b49650505050505050565b604080519115158252519081900360200190f35b3480156100d157600080fd5b506100b16102fd565b3480156100e657600080fd5b5060408051602060046024803582810135601f81018590048502860185019096528585526100b1958335600160a060020a031695369560449491939091019190819084018382808284375094975050933594506103039350505050565b34801561014f57600080fd5b50604080516020600460443581810135601f81018490048402850184019095528484526100b1948235600160a060020a0390811695602480359092169536959460649492930191908190840183828082843750949750509335945061043e9350505050565b6003805460408051602060026001851615610100026000190190941693909304601f810184900484028201840190925281815260009361024d93919290918301828280156102435780601f1061021857610100808354040283529160200191610243565b820191906000526020600020905b81548152906001019060200180831161022657829003601f168201915b50505050506104bc565b610256836104bc565b14156102f357604080517f7472616e736665725f746f6b656e2875696e743235362c6164647265737329008152815190819003601f0181206004805460025463ffffffff60e060020a94859004908116909402855291840152600160a060020a0390811660248401529251928616929091604480820192600092909190829003018183875af19250505015156102eb57600080fd5b5060016102f7565b5060005b92915050565b60015b90565b600083600160a060020a031660405180807f6372656174654c6f616e28737472696e672c616464726573732c75696e74323581526020017f36290000000000000000000000000000000000000000000000000000000000008152506022019050604051809103902060e060020a900484600260009054906101000a9004600160a060020a0316856040518463ffffffff1660e060020a02815260040180848051906020019080838360005b838110156103c65781810151838201526020016103ae565b50505050905090810190601f1680156103f35780820380516001836020036101000a031916815260200191505b5083600160a060020a0316600160a060020a0316815260200182815260200193505050506000604051808303816000875af192505050151561043457600080fd5b5060019392505050565b60008054600160a060020a03163314156104b05760018054600160a060020a0380881673ffffffffffffffffffffffffffffffffffffffff1992831617909255600280549287169290911691909117905582516104a29060039060208601906104e0565b5050600481905560016104b4565b5060005b949350505050565b8051600090829015156104d257600091506104da565b602083015191505b50919050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061052157805160ff191683800117855561054e565b8280016001018555821561054e579182015b8281111561054e578251825591602001919060010190610533565b5061055a92915061055e565b5090565b61030091905b8082111561055a57600081556001016105645600a165627a7a7230582007c19f1deb221153ce3a83becdfc6c7f755aceffe84c9bc34ef9496f217c30740029";

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
