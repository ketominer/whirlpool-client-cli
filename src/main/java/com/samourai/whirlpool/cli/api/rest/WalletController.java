package com.samourai.whirlpool.cli.api.rest;

import com.samourai.whirlpool.cli.api.rest.protocol.ApiWalletResponse;
import com.samourai.whirlpool.cli.services.CliWalletService;
import com.samourai.whirlpool.cli.wallet.CliWallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletController {
  private static final String ENDPOINT = "/wallet";

  @Autowired private CliWalletService cliWalletService;

  @RequestMapping(value = ENDPOINT)
  public ApiWalletResponse wallet(@RequestParam(value = "name", defaultValue = "World") String name)
      throws Exception {
    CliWallet cliWallet = cliWalletService.getCliWallet();
    cliWallet.clearCache(); // TODO
    return new ApiWalletResponse(cliWallet);
  }
}