package com.orangehrm.base;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiBaseClass {

	protected RequestSpecification reqSpec;
	protected Response response;

	public void initRequest() {
		reqSpec = RestAssured.given();
	}

	public void addHeader(String key, String value) {
		reqSpec.header(key, value);
	}

	public void addHeaders(Headers headers) {
		reqSpec.headers(headers);
	}

	public void addPayload(Object body) {
		reqSpec.body(body);
	}

	public Response sendRequest(String type, String endpoint) {

		switch (type.toUpperCase()) {

		case "GET":
			response = reqSpec.get(endpoint);
			break;

		case "POST":
			response = reqSpec.post(endpoint);
			break;

		case "PUT":
			response = reqSpec.put(endpoint);
			break;

		case "DELETE":
			response = reqSpec.delete(endpoint);
			break;

		default:
			throw new IllegalArgumentException("Invalid Request Type");
		}

		return response;
	}

	public int getStatusCode(Response response) {
		return response.getStatusCode();
	}

	public String getResponseBody(Response response) {
		return response.asPrettyString();
	}

	public void addDefaultHeaders() {
		addHeader("Content-Type", "application/json");
		addHeader("x-api-key", "reqres_9ba4b0ccb3c44a518ab630d375a7a7d8");
	}
}