package com.AlfredoGomez.StockSystem.StockSystem.Web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.AlfredoGomez.StockSystem.StockSystem.Entity.Broker;
import com.AlfredoGomez.StockSystem.StockSystem.Service.TradingService;

@Controller
@RequestMapping("/brokers")
public class BrokerWebController {
	
	private final TradingService tradingService;
	
	@Autowired
	public BrokerWebController(TradingService tradingService) {
		super();
		this.tradingService = tradingService;
	}
	
	@GetMapping
	public String getBrokers(Model model) {
		List<Broker> brokers = this.tradingService.getBrokers();
		model.addAttribute("brokers", brokers);
		return "brokers";
	}
	
	
	
}
