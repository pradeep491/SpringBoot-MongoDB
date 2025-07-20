package currency_exchange_jpa.repos;


import currency_exchange_jpa.bean.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
    CurrencyExchange findByFromAndTo(String from, String to);
}
