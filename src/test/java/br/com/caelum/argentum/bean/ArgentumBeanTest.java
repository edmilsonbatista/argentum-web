package br.com.caelum.argentum.bean;

import java.util.Date;
import org.junit.Test;
import org.junit.Assert;

public class ArgentumBeanTest {

    @Test
    public void testGettersSetters() {
        ArgentumBean bean = new ArgentumBean();
        
        bean.setNomeIndicadorBase("IndicadorAbertura");
        Assert.assertEquals("IndicadorAbertura", bean.getNomeIndicadorBase());
        
        bean.setNomeMedia("MediaMovelSimples");
        Assert.assertEquals("MediaMovelSimples", bean.getNomeMedia());
        
        Date data = new Date();
        bean.setFiltroDataDe(data);
        Assert.assertEquals(data, bean.getFiltroDataDe());
        
        bean.setFiltroDataAte(data);
        Assert.assertEquals(data, bean.getFiltroDataAte());
    }

    @Test
    public void testModeloGrafico() {
        ArgentumBean bean = new ArgentumBean();
        Assert.assertNotNull(bean.getModeloGrafico());
    }

    @Test
    public void testNegociacoes() {
        ArgentumBean bean = new ArgentumBean();
        Assert.assertNotNull(bean.getNegociacoes());
    }
}