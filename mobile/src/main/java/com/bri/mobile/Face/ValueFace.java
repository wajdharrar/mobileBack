package com.bri.mobile.Face;

import com.bri.mobile.Entity.UserPhoneId;
import com.bri.mobile.Entity.Value;

import java.util.List;

public interface ValueFace {
    List<Value> getAllValues();
    Value getValueById(int id);
    Value addValue(Value value);
    Value updateValue(Value value, int id);
    void deleteValue(int id);
}
