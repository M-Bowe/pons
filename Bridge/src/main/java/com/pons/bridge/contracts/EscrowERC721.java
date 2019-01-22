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
    private static final String BINARY = "608060405234801561001057600080fd5b5060008054600160a060020a0319163317905561046e806100326000396000f3006080604052600436106100615763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416634d5b608b8114610063578063886ed6b414610098578063ae0113d114610109578063eafc10061461012a575b005b34801561006f57600080fd5b50610084600160a060020a0360043516610183565b604080519115158252519081900360200190f35b3480156100a457600080fd5b50604080516020600460443581810135601f8101849004840285018401909552848452610084948235600160a060020a039081169560248035909216953695946064949293019190819084018382808284375094975050933594506102359350505050565b34801561011557600080fd5b50610061600160a060020a03600435166102b3565b34801561013657600080fd5b506040805160206004803580820135601f81018490048402850184019095528484526100849436949293602493928401919081908401838280828437509497506102bf9650505050505050565b604080517f7472616e7366657228616464726573732c75696e743235362900000000000000815281519081900360190181206002546004805463ffffffff7c0100000000000000000000000000000000000000000000000000000000948590049081169094028552600160a060020a0392831691850191909152602484015292516000938516926044808201928692909190829003018183875af192505050151561022d57600080fd5b506001919050565b60008054600160a060020a03163314156102a75760018054600160a060020a0380881673ffffffffffffffffffffffffffffffffffffffff1992831617909255600280549287169290911691909117905582516102999060039060208601906103a7565b5050600481905560016102ab565b5060005b949350505050565b80600160a060020a0316ff5b60006102ca82610383565b60038054604080516020601f6002610100600187161502600019019095169490940493840181900481028201810190925282815261036193909290918301828280156103575780601f1061032c57610100808354040283529160200191610357565b820191906000526020600020905b81548152906001019060200180831161033a57829003601f168201915b5050505050610383565b141561037557600254600160a060020a0316ff5b600154600160a060020a0316ff5b80516000908290151561039957600091506103a1565b602083015191505b50919050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106103e857805160ff1916838001178555610415565b82800160010185558215610415579182015b828111156104155782518255916020019190600101906103fa565b50610421929150610425565b5090565b61043f91905b80821115610421576000815560010161042b565b905600a165627a7a72305820b12358d8ca89d02f7f88aa4ba7698a85c249d046020c3751870108f97e0bff8a0029";

    public static final String FUNC_TESTTRANSFER = "testTransfer";

    public static final String FUNC_SETPARAMS = "setParams";

    public static final String FUNC_TESTSD = "testSD";

    public static final String FUNC_FREEFROMESCROW = "freeFromEscrow";

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

    public RemoteCall<TransactionReceipt> testTransfer(String _existingContract) {
        final Function function = new Function(
                FUNC_TESTTRANSFER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_existingContract)), 
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
