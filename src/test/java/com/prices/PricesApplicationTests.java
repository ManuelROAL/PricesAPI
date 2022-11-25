package com.prices;

import com.prices.controller.PriceController;
import com.prices.entity.Price;
import com.prices.response.PriceResponse;
import com.prices.service.PriceService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.text.SimpleDateFormat;

@RunWith(SpringRunner.class)
@WebMvcTest(value = PriceController.class)
class PricesApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ModelMapper modelMapper;

	@MockBean
	private PriceService priceService;

	@Test
	public void testPrice1() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");

		Price mockPrice = new Price(1, sdf.parse("2020-06-14-00.00.00"), sdf.parse("2020-12-31-23.59.59"),
				1, 35455L, 0, 35.50, "EUR");

		PriceResponse mockPriceResponse = modelMapper.map(mockPrice, PriceResponse.class);


		Mockito.when(priceService.consultPrice(sdf.parse("2020-06-14-10.00.00"), 35455L, 1)).thenReturn(mockPriceResponse);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/prices/2020-06-14-10.00.00/35455/1")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{\"brandId\":1,\"startDate\":\"2020-06-14-00.00.00\",\"endDate\":\"2020-12-31-23.59.59\",\"priceList\":1,\"productId\":35455,\"price\":35.5}";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

	@Test
	public void testPrice2() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");

		Price mockPrice = new Price(1, sdf.parse("2020-06-14-15.00.00"), sdf.parse("2020-06-14-18.30.00"),
				2, 35455L, 0, 25.45, "EUR");

		PriceResponse mockPriceResponse = modelMapper.map(mockPrice, PriceResponse.class);


		Mockito.when(priceService.consultPrice(sdf.parse("2020-06-14-16.00.00"), 35455L, 1)).thenReturn(mockPriceResponse);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/prices/2020-06-14-16.00.00/35455/1")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{\"brandId\":1,\"startDate\":\"2020-06-14-15.00.00\",\"endDate\":\"2020-06-14-18.30.00\",\"priceList\":2,\"productId\":35455,\"price\":25.45}";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

	@Test
	public void testPrice3() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");

		Price mockPrice = new Price(1, sdf.parse("2020-06-14-00.00.00"), sdf.parse("2020-12-31-23.59.59"),
				1, 35455L, 0, 35.50, "EUR");

		PriceResponse mockPriceResponse = modelMapper.map(mockPrice, PriceResponse.class);


		Mockito.when(priceService.consultPrice(sdf.parse("2020-06-14-21.00.00"), 35455L, 1)).thenReturn(mockPriceResponse);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/prices/2020-06-14-21.00.00/35455/1")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{\"brandId\":1,\"startDate\":\"2020-06-14-00.00.00\",\"endDate\":\"2020-12-31-23.59.59\",\"priceList\":1,\"productId\":35455,\"price\":35.5}";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

	@Test
	public void testPrice4() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");

		Price mockPrice = new Price(1, sdf.parse("2020-06-15-00.00.00"), sdf.parse("2020-06-15-11.00.00"),
				3, 35455L, 0, 30.50, "EUR");

		PriceResponse mockPriceResponse = modelMapper.map(mockPrice, PriceResponse.class);


		Mockito.when(priceService.consultPrice(sdf.parse("2020-06-15-10.00.00"), 35455L, 1)).thenReturn(mockPriceResponse);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/prices/2020-06-15-10.00.00/35455/1")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{\"brandId\":1,\"startDate\":\"2020-06-15-00.00.00\",\"endDate\":\"2020-06-15-11.00.00\",\"priceList\":3,\"productId\":35455,\"price\":30.5}";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

	@Test
	public void testPrice5() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");

		Price mockPrice = new Price(1, sdf.parse("2020-06-15-16.00.00"), sdf.parse("2020-12-31-23.59.59"),
				4, 35455L, 4, 38.95, "EUR");

		PriceResponse mockPriceResponse = modelMapper.map(mockPrice, PriceResponse.class);


		Mockito.when(priceService.consultPrice(sdf.parse("2020-06-15-21.00.00"), 35455L, 1)).thenReturn(mockPriceResponse);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/prices/2020-06-15-21.00.00/35455/1")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{\"brandId\":1,\"startDate\":\"2020-06-15-16.00.00\",\"endDate\":\"2020-12-31-23.59.59\",\"priceList\":4,\"productId\":35455,\"price\":38.95}";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
}