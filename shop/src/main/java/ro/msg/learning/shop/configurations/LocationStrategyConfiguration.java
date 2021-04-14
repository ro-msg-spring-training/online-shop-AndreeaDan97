package ro.msg.learning.shop.configurations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.msg.learning.shop.services.strategy.LocationStrategy;
import ro.msg.learning.shop.services.strategy.MostAbundantLocationStrategy;
import ro.msg.learning.shop.services.strategy.SingleLocationStrategy;

@Configuration
public class LocationStrategyConfiguration {

    @Bean
    public static LocationStrategy chooseLocationStrategy(@Value("${my.strategy}") String strategy){
        if(strategy.equals("single")){
            return new SingleLocationStrategy();
        }else if (strategy.equals("abundant")){
            return new MostAbundantLocationStrategy();
        }
        throw new RuntimeException("strategy not defined!");
    }
}
