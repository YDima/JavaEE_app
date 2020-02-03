package JavaApp.user.auction.create_edit.auctionParameter;

import JavaApp.Retriever;
import JavaApp.sales.jpa.AuctionParameter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;

@Named
@RequestScoped
public class AuctionParameterController {


        @Inject
        AuctionParameterRequest auctionParameterRequest;
        @Inject
        private HttpServletRequest request;
        @PersistenceContext
        private EntityManager em;
        @Inject
        private Retriever retriever;
        @Inject
        private AuctionParameterRepository auctionParameterRepository;

        public AuctionParameterRequest getAuctionParameterRequest() {
            if (auctionParameterRequest == null) {
                auctionParameterRequest = createAuctionParameterRequest();
            }
            return auctionParameterRequest;
        }

        public AuctionParameterRequest createAuctionParameterRequest(){
            if (retriever.contains("id")) {
                var id = retriever.getLong("id");
                var auctionParameter = auctionParameterRepository.findAuctionParameterById(id);
                return new AuctionParameterRequest(auctionParameter);
            }
            return new AuctionParameterRequest();
        }




        public String save() {
//            Long auction_id = auctionParameterRequest.getAuction_id();
//            Long parameter_id = auctionParameterRequest.getParameter_id();
//            String value = auctionParameterRequest.getValue();
//            auctionParameterRequest.setAuction_id(auction_id);
//            auctionParameterRequest.setAuction_id(parameter_id);

            AuctionParameter auctionParameter = new AuctionParameter(auctionParameterRequest.getAuction_id(), auctionParameterRequest.getParameter_id(), auctionParameterRequest.getValue());
            auctionParameterRepository.save(auctionParameter);

            return "createAuctionParameters.xhtml?faces-redirect=true";
        }

    public String edit() {
        AuctionParameter auctionParameter = new AuctionParameter(auctionParameterRequest.getAuction_id(), auctionParameterRequest.getParameter_id(), auctionParameterRequest.getValue());
        auctionParameterRepository.edit(auctionParameter);

        return "editAuctionParameters.xhtml?faces-redirect=true";
    }
    }












































