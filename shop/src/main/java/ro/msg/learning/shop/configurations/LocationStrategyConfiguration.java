package ro.msg.learning.shop.configurations;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.msg.learning.shop.configurations.exceptions.StrategyNotDefined;
import ro.msg.learning.shop.repositories.StockRepository;
import ro.msg.learning.shop.services.strategy.LocationStrategy;
import ro.msg.learning.shop.services.strategy.MostAbundantLocationStrategy;
import ro.msg.learning.shop.services.strategy.SingleLocationStrategy;
import ro.msg.learning.shop.utils.StrategyType;

@Configuration
@RequiredArgsConstructor
public class LocationStrategyConfiguration {

    private final StockRepository stockRepository;

    @Bean
    public LocationStrategy chooseLocationStrategy(@Value("${my.strategy}") StrategyType strategy) {
        if (strategy == StrategyType.SINGLE) {
            return new SingleLocationStrategy(stockRepository);
        } else if (strategy == StrategyType.ABUNDANT) {
            return new MostAbundantLocationStrategy(stockRepository);
        }
        return null;
    }
}
