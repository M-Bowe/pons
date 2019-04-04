package com.pons.bridge.web3j;

import java.math.BigInteger;

import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.quorum.Quorum;
import org.web3j.tx.gas.ContractGasProvider;

import com.pons.bridge.contracts.EscrowERC20;
import com.pons.bridge.contracts.EscrowERC721;
import com.pons.bridge.contracts.Loan;
import com.pons.bridge.contracts.MonetaryToken;
import com.pons.bridge.responses.Response;
import com.pons.bridge.tempModels.EscrowParams;

@Service("escrowContractService")
public class EscrowContractService {

	private Quorum erc20Web3j;
	private Quorum erc721Web3j;
	private MasterNode20 masterNode20;
	private MasterNode721 masterNode721;
	private ContractGasProvider gasProvider;

	public EscrowContractService(){
		masterNode20 = MasterNode20.getInstance();
		masterNode721 = MasterNode721.getInstance();
		erc20Web3j = masterNode20.getWeb3j();
		erc721Web3j = masterNode721.getWeb3j();
		gasProvider = new DeployGasProvider();
	}

	/***************************************************************************************************************
	 ************************************************ ERC 20 *******************************************************
	 **************************************************************************************************************/

	public String createEscrowOnERC20(String from, String to, BigInteger quantity, String passcode){
		System.out.println("Deploying Escrow to ERC20 Chain");
		EscrowERC20 escrowContract;
		try {
			escrowContract = EscrowERC20.deploy(erc20Web3j, masterNode20.getCredentials(), gasProvider).send();
			escrowContract.setParams(from, to, passcode, quantity).send();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
        String contractAddress = escrowContract.getContractAddress();
        System.out.println("Escrow deployed to ERC20 Chain: " + contractAddress);
        return contractAddress;
	}

	public EscrowERC20 loadEscrowfromERC20Chain(String contractAddress){
		ContractGasProvider contractGasProvider = new DeployGasProvider();
		return EscrowERC20.load(contractAddress, erc20Web3j, masterNode20.getCredentials(), contractGasProvider);
	}

	public boolean approveERC20(String address, String passcode) {
		EscrowERC20 erc20 = loadEscrowfromERC20Chain(address);
		System.out.println("Address: " + address + "  Passcode: " + passcode + "  erc20Address: " + masterNode20.getErc20TokenAddress());
		try {
			return erc20.freeFromEscrow(masterNode20.getErc20TokenAddress(), passcode).send().isStatusOK();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/***************************************************************************************************************
	 ************************************************ ERC 721 ******************************************************
	 **************************************************************************************************************/

	public String createEscrowOnERC721(String from, String to, BigInteger tokenId, String passcode){
        System.out.println("Deploying Escrow to ERC721 Chain");
        EscrowERC721 escrowContract;
		try {
			escrowContract = EscrowERC721.deploy(erc721Web3j, masterNode721.getCredentials(), gasProvider).send();
			escrowContract.setParams(from, to, passcode, tokenId).send();
			System.out.println("From: " + from + "  To: " + to + "  Passcode: " + passcode + "  TokenID: " + tokenId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
        String contractAddress = escrowContract.getContractAddress();
        System.out.println("Escrow deployed to ERC721 Chain: " + contractAddress);
        return contractAddress;
	}

	public EscrowERC721 loadEscrowfromERC721Chain(String contractAddress){
		ContractGasProvider contractGasProvider = new DeployGasProvider();
		return EscrowERC721.load(contractAddress, erc721Web3j, masterNode721.getCredentials(), contractGasProvider);
	}

	public boolean approveERC721(String address, String passcode) {
		EscrowERC721 erc721 = loadEscrowfromERC721Chain(address);
		System.out.println("Address: " + address + "  Passcode: " + passcode + "  erc721Address: " + masterNode721.getErc721ContractAddress());
		try {
			return erc721.freeFromEscrow(masterNode721.getErc721ContractAddress(), passcode).send().isStatusOK();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public EscrowParams getEscrowParams(String escrow20address, String escrow721address) {
		EscrowParams params = new EscrowParams();
		
		String e20to = null, e20from = null, e20Amount = null;
		EscrowERC20 erc20 = loadEscrowfromERC20Chain(escrow20address);
		try {
			e20to = erc20.getTo().send();
			e20from = erc20.getFrom().send();
			e20Amount = erc20.getAmount().send().toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		params.setERC20Params(e20to, e20from, e20Amount);
		
		EscrowERC721 erc721 = loadEscrowfromERC721Chain(escrow721address);
		String e721to = null, e721from = null, e721id = null;
		try {
			e721to = erc721.getTo().send();
			e721from = erc721.getFrom().send();
			e721id = erc721.getTokenId().send().toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		params.setERC721Params(e721to, e721from, e721id);
		
		return params;
	}

}
