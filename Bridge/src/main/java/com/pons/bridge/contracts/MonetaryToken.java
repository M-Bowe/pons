package com.pons.bridge.contracts;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.6.0.
 */
public class MonetaryToken extends Contract {
    private static final String BINARY = "60c0604052600460808190527f48312e300000000000000000000000000000000000000000000000000000000060a090815262000040916009919062000169565b503480156200004e57600080fd5b50620f4240600481905533600090815260208181526040808320939093556005919091558151808301909252600e8083527f4d6f6e657461727920546f6b656e00000000000000000000000000000000000092909101918252620000b59160069162000169565b506007805460ff191660121790556040805180820190915260038082527f4d4f4e00000000000000000000000000000000000000000000000000000000006020909201918252620001099160089162000169565b50600a8054600160a060020a03191633908117909155604080516020818101808452600080845294855260029091529190922091516200014b92919062000169565b50336000908152600160205260409020805460ff191690556200020e565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10620001ac57805160ff1916838001178555620001dc565b82800160010185558215620001dc579182015b82811115620001dc578251825591602001919060010190620001bf565b50620001ea929150620001ee565b5090565b6200020b91905b80821115620001ea5760008155600101620001f5565b90565b6111d8806200021e6000396000f3006080604052600436106101035763ffffffff60e060020a60003504166306fdde038114610115578063095ea7b31461019f57806318160ddd146101d7578063224b610b146101fe57806323b872dd14610213578063290bb4531461023d578063313ce5671461029857806352196812146102c357806354fd4d50146102d8578063599e74af146102ed57806370a08231146103465780639358928b1461036757806395d89b411461037c578063a63c500f14610391578063a9059cbb146103a6578063bbf770d5146103ca578063bed34bba1461042e578063cae9ca51146104c5578063ce0e19ba1461052e578063dd62ed3e14610587578063dd83fdf6146105ae575b34801561010f57600080fd5b50600080fd5b34801561012157600080fd5b5061012a610607565b6040805160208082528351818301528351919283929083019185019080838360005b8381101561016457818101518382015260200161014c565b50505050905090810190601f1680156101915780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b3480156101ab57600080fd5b506101c3600160a060020a0360043516602435610695565b604080519115158252519081900360200190f35b3480156101e357600080fd5b506101ec6106fc565b60408051918252519081900360200190f35b34801561020a57600080fd5b5061012a610702565b34801561021f57600080fd5b506101c3600160a060020a036004358116906024351660443561075d565b34801561024957600080fd5b506040805160206004803580820135601f81018490048402850184019095528484526102969436949293602493928401919081908401838280828437509497506108489650505050505050565b005b3480156102a457600080fd5b506102ad61086c565b6040805160ff9092168252519081900360200190f35b3480156102cf57600080fd5b506101ec610875565b3480156102e457600080fd5b5061012a610894565b3480156102f957600080fd5b506040805160206004803580820135601f81018490048402850184019095528484526101c39436949293602493928401919081908401838280828437509497506108ef9650505050505050565b34801561035257600080fd5b506101ec600160a060020a0360043516610a45565b34801561037357600080fd5b506101ec610a60565b34801561038857600080fd5b5061012a610a66565b34801561039d57600080fd5b506101c3610ac1565b3480156103b257600080fd5b506101c3600160a060020a0360043516602435610ae2565b3480156103d657600080fd5b506040805160206004803580820135601f81018490048402850184019095528484526101c394369492936024939284019190819084018382808284375094975050509235600160a060020a03169350610b7992505050565b34801561043a57600080fd5b506040805160206004803580820135601f81018490048402850184019095528484526101c394369492936024939284019190819084018382808284375050604080516020601f89358b018035918201839004830284018301909452808352979a999881019791965091820194509250829150840183828082843750949750610cb19650505050505050565b3480156104d157600080fd5b50604080516020600460443581810135601f81018490048402850184019095528484526101c3948235600160a060020a0316946024803595369594606494920191908190840183828082843750949750610e459650505050505050565b34801561053a57600080fd5b506040805160206004803580820135601f81018490048402850184019095528484526101ec943694929360249392840191908190840183828082843750949750610fe09650505050505050565b34801561059357600080fd5b506101ec600160a060020a0360043581169060243516611027565b3480156105ba57600080fd5b506040805160206004803580820135601f81018490048402850184019095528484526101c39436949293602493928401919081908401838280828437509497506110529650505050505050565b6006805460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152929183018282801561068d5780601f106106625761010080835404028352916020019161068d565b820191906000526020600020905b81548152906001019060200180831161067057829003601f168201915b505050505081565b336000818152600360209081526040808320600160a060020a038716808552908352818420869055815186815291519394909390927f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925928290030190a35060015b92915050565b60045481565b600b805460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152929183018282801561068d5780601f106106625761010080835404028352916020019161068d565b600160a060020a03831660009081526020819052604081205482118015906107a85750600160a060020a03841660009081526003602090815260408083203384529091529020548211155b80156107b45750600082115b1561083d57600160a060020a0380841660008181526020818152604080832080548801905593881680835284832080548890039055600382528483203384528252918490208054879003905583518681529351929391927fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef9281900390910190a3506001610841565b5060005b9392505050565b336000908152600260209081526040909120825161086892840190611114565b5050565b60075460ff1681565b600a54600160a060020a03166000908152600c60205260409020545b90565b6009805460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152929183018282801561068d5780601f106106625761010080835404028352916020019161068d565b336000908152600260208181526040808420805482516001821615610100026000190190911694909404601f810184900484028501840190925281845261099093929091908301828280156109855780601f1061095a57610100808354040283529160200191610985565b820191906000526020600020905b81548152906001019060200180831161096857829003601f168201915b505050505083610cb1565b156109b75750336000908152600160208190526040909120805460ff191682179055610a40565b33600090815260026020818152604092839020805484516001821615610100026000190190911693909304601f8101839004830284018301909452838352610a219390918301828280156109855780601f1061095a57610100808354040283529160200191610985565b1515610a405750336000908152600160205260408120805460ff191690555b919050565b600160a060020a031660009081526020819052604090205490565b60055481565b6008805460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152929183018282801561068d5780601f106106625761010080835404028352916020019161068d565b600a5474010000000000000000000000000000000000000000900460ff1681565b336000908152602081905260408120548211801590610b015750600082115b15610b71573360008181526020818152604080832080548790039055600160a060020a03871680845292819020805487019055805186815290519293927fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef929181900390910190a35060016106f6565b5060006106f6565b600160a060020a0381166000908152600260208181526040808420805482516001821615610100026000190190911694909404601f8101849004840285018401909252818452610c239392909190830182828015610c185780601f10610bed57610100808354040283529160200191610c18565b820191906000526020600020905b815481529060010190602001808311610bfb57829003601f168201915b505050505084610cb1565b15610c30575060016106f6565b600160a060020a038216600090815260026020818152604092839020805484516001821615610100026000190190911693909304601f8101839004830284018301909452838352610ca3939091830182828015610c185780601f10610bed57610100808354040283529160200191610c18565b15156106f6575060006106f6565b6000826040518082805190602001908083835b60208310610ce35780518252601f199092019160209182019101610cc4565b5181516020939093036101000a60001901801990911692169190911790526040519201829003909120159250829150610d7890505750816040518082805190602001908083835b60208310610d495780518252601f199092019160209182019101610d2a565b5181516020939093036101000a6000190180199091169216919091179052604051920182900390912015925050505b15610d85575060006106f6565b816040518082805190602001908083835b60208310610db55780518252601f199092019160209182019101610d96565b51815160209384036101000a6000190180199092169116179052604051919093018190038120885190955088945090928392508401908083835b60208310610e0e5780518252601f199092019160209182019101610def565b5181516020939093036101000a60001901801990911692169190911790526040519201829003909120939093149695505050505050565b336000818152600360209081526040808320600160a060020a038816808552908352818420879055815187815291519394909390927f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925928290030190a383600160a060020a031660405180807f72656365697665417070726f76616c28616464726573732c75696e743235362c81526020017f616464726573732c627974657329000000000000000000000000000000000000815250602e019050604051809103902060e060020a9004338530866040518563ffffffff1660e060020a0281526004018085600160a060020a0316600160a060020a0316815260200184815260200183600160a060020a0316600160a060020a03168152602001828051906020019080838360005b83811015610f85578181015183820152602001610f6d565b50505050905090810190601f168015610fb25780820380516001836020036101000a031916815260200191505b509450505050506000604051808303816000875af1925050501515610fd657600080fd5b5060019392505050565b600a54600160a060020a03166000908152600c60209081526040822080546001810180835591845282842085519293611020939190920191860190611114565b5092915050565b600160a060020a03918216600090815260036020908152604080832093909416825291909152205490565b6000805b61105e610875565b81101561110957600a54600160a060020a03166000908152600c6020526040902080546110f391908390811061109057fe5b600091825260209182902001805460408051601f6002600019610100600187161502019094169390930492830185900485028101850190915281815292830182828015610c185780601f10610bed57610100808354040283529160200191610c18565b15611101576000915061110e565b600101611056565b600191505b50919050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061115557805160ff1916838001178555611182565b82800160010185558215611182579182015b82811115611182578251825591602001919060010190611167565b5061118e929150611192565b5090565b61089191905b8082111561118e57600081556001016111985600a165627a7a723058204735b340fcb7b1d3a99ae9d953e1ca14aa057ae8584813cbca94748d180379d00029";

    public static final String FUNC_NAME = "name";

    public static final String FUNC_APPROVE = "approve";

    public static final String FUNC_TOTALSUPPLY = "totalSupply";

    public static final String FUNC_PASSWORD = "password";

    public static final String FUNC_TRANSFERFROM = "transferFrom";

    public static final String FUNC_SETPASSWORD = "setPassword";

    public static final String FUNC_DECIMALS = "decimals";

    public static final String FUNC_GETLOANCOUNT = "getLoanCount";

    public static final String FUNC_VERSION = "version";

    public static final String FUNC_LOCKCONTRACT = "lockContract";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_CIRCULATINGSUPPLY = "circulatingSupply";

    public static final String FUNC_SYMBOL = "symbol";

    public static final String FUNC_IS_LOCKED = "is_locked";

    public static final String FUNC_TRANSFER = "transfer";

    public static final String FUNC_CHECKLOCKSTATUS = "checkLockStatus";

    public static final String FUNC_COMPARESTRINGS = "compareStrings";

    public static final String FUNC_APPROVEANDCALL = "approveAndCall";

    public static final String FUNC_APPENDSTRING = "appendString";

    public static final String FUNC_ALLOWANCE = "allowance";

    public static final String FUNC_VALIDLOANADDRESS = "validLoanAddress";

    public static final Event TRANSFER_EVENT = new Event("Transfer", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event APPROVAL_EVENT = new Event("Approval", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected MonetaryToken(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected MonetaryToken(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected MonetaryToken(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected MonetaryToken(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<String> name() {
        final Function function = new Function(FUNC_NAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> approve(String _spender, BigInteger _value) {
        final Function function = new Function(
                FUNC_APPROVE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_spender), 
                new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> totalSupply() {
        final Function function = new Function(FUNC_TOTALSUPPLY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> password() {
        final Function function = new Function(FUNC_PASSWORD, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> transferFrom(String _from, String _to, BigInteger _value) {
        final Function function = new Function(
                FUNC_TRANSFERFROM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_from), 
                new org.web3j.abi.datatypes.Address(_to), 
                new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setPassword(String pass) {
        final Function function = new Function(
                FUNC_SETPASSWORD, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(pass)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> decimals() {
        final Function function = new Function(FUNC_DECIMALS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getLoanCount() {
        final Function function = new Function(FUNC_GETLOANCOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> version() {
        final Function function = new Function(FUNC_VERSION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> lockContract(String local_pass) {
        final Function function = new Function(
                FUNC_LOCKCONTRACT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(local_pass)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> balanceOf(String _owner) {
        final Function function = new Function(FUNC_BALANCEOF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_owner)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> circulatingSupply() {
        final Function function = new Function(FUNC_CIRCULATINGSUPPLY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> symbol() {
        final Function function = new Function(FUNC_SYMBOL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<Boolean> is_locked() {
        final Function function = new Function(FUNC_IS_LOCKED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> transfer(String _to, BigInteger _value) {
        final Function function = new Function(
                FUNC_TRANSFER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_to), 
                new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> checkLockStatus(String local_pass, String checkAddress) {
        final Function function = new Function(
                FUNC_CHECKLOCKSTATUS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(local_pass), 
                new org.web3j.abi.datatypes.Address(checkAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Boolean> compareStrings(String a, String b) {
        final Function function = new Function(FUNC_COMPARESTRINGS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(a), 
                new org.web3j.abi.datatypes.Utf8String(b)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> approveAndCall(String _spender, BigInteger _value, byte[] _extraData) {
        final Function function = new Function(
                FUNC_APPROVEANDCALL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_spender), 
                new org.web3j.abi.datatypes.generated.Uint256(_value), 
                new org.web3j.abi.datatypes.DynamicBytes(_extraData)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> appendString(String appendThis) {
        final Function function = new Function(
                FUNC_APPENDSTRING, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(appendThis)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> allowance(String _owner, String _spender) {
        final Function function = new Function(FUNC_ALLOWANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_owner), 
                new org.web3j.abi.datatypes.Address(_spender)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Boolean> validLoanAddress(String checkVal) {
        final Function function = new Function(FUNC_VALIDLOANADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(checkVal)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public static RemoteCall<MonetaryToken> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(MonetaryToken.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<MonetaryToken> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(MonetaryToken.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<MonetaryToken> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MonetaryToken.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<MonetaryToken> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MonetaryToken.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public List<TransferEventResponse> getTransferEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(TRANSFER_EVENT, transactionReceipt);
        ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TransferEventResponse typedResponse = new TransferEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse._value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<TransferEventResponse> transferEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, TransferEventResponse>() {
            @Override
            public TransferEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(TRANSFER_EVENT, log);
                TransferEventResponse typedResponse = new TransferEventResponse();
                typedResponse.log = log;
                typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._to = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse._value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<TransferEventResponse> transferEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TRANSFER_EVENT));
        return transferEventObservable(filter);
    }

    public List<ApprovalEventResponse> getApprovalEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(APPROVAL_EVENT, transactionReceipt);
        ArrayList<ApprovalEventResponse> responses = new ArrayList<ApprovalEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ApprovalEventResponse typedResponse = new ApprovalEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._owner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._spender = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse._value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<ApprovalEventResponse> approvalEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, ApprovalEventResponse>() {
            @Override
            public ApprovalEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(APPROVAL_EVENT, log);
                ApprovalEventResponse typedResponse = new ApprovalEventResponse();
                typedResponse.log = log;
                typedResponse._owner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._spender = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse._value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<ApprovalEventResponse> approvalEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(APPROVAL_EVENT));
        return approvalEventObservable(filter);
    }

    @Deprecated
    public static MonetaryToken load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new MonetaryToken(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static MonetaryToken load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new MonetaryToken(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static MonetaryToken load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new MonetaryToken(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static MonetaryToken load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new MonetaryToken(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static class TransferEventResponse {
        public Log log;

        public String _from;

        public String _to;

        public BigInteger _value;
    }

    public static class ApprovalEventResponse {
        public Log log;

        public String _owner;

        public String _spender;

        public BigInteger _value;
    }
}
