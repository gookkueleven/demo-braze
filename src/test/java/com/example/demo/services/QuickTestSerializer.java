package com.example.demo.services;

import com.example.demo.models.InnerModel;
import com.example.demo.models.TestSerializeModel;
import com.example.demo.serializer.TestSerializer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class QuickTestSerializer {

    @Test
    public void testSerializer() {
        InnerModel innerModel = new InnerModel();
        innerModel.setMessage("1000");

        TestSerializeModel model = new TestSerializeModel();
        model.setInner(innerModel);

        Assert.assertEquals("1000", model.getInner().getMessage());
    }
}
