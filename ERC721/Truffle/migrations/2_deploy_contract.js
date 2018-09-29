var PonsToken = artifacts.require("PonsToken");

module.exports = function(deployer) {
    deployer.deploy(PonsToken);
};