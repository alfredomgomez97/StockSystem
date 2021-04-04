package com.AlfredoGomez.StockSystem.StockSystem.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AlfredoGomez.StockSystem.StockSystem.Entity.Broker;
import com.AlfredoGomez.StockSystem.StockSystem.Repository.BrokerRepository;

@Service
public class TradingService {
	private final BrokerRepository brokerRepository;
	
	@Autowired
	public TradingService(BrokerRepository brokerRepository) {
		super();
		this.brokerRepository = brokerRepository;
	}
	public List<Broker> getBrokers(){
		Iterable<Broker> brokers = this.brokerRepository.findAll();
		List<Broker> brokerList = new ArrayList<>();
		brokers.forEach(broker ->{brokerList.add(broker);});
		brokerList.sort(new Comparator<Broker>() {
			@Override
			public int compare(Broker o1, Broker o2) {
				if (o1.getLastName() == o2.getLastName()){
                    return o1.getFirstName().compareTo(o2.getFirstName());
                }
				 return o1.getLastName().compareTo(o2.getLastName());
            }
			});
			return brokerList;
			
		
	}
	
	
}
