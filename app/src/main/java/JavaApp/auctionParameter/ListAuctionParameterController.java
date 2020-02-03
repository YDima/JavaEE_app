package JavaApp.auctionParameter;


import JavaApp.sales.AuctionParameter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class ListAuctionParameterController {

    @Inject
    AuctionParameterRepository auctionParameterRepository;

    public List<AuctionParameter> getAuctionParameterListByAuction() {
        return auctionParameterRepository.findByAuctionId();
    }

    public List<AuctionParameter> getAuctionParameterList() {
        return auctionParameterRepository.findAll();
    }
}
