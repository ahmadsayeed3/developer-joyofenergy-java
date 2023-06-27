package uk.tw.energy.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface AccountService {

    String getPricePlanIdForSmartMeterId(String smartMeterId);
}
