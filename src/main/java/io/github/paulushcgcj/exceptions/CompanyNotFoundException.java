package io.github.paulushcgcj.exceptions;

public class CompanyNotFoundException extends CompanyHubException {
    public CompanyNotFoundException(Integer id) {
        super(String.format("Company with id %d was not found",id), 404);
    }
}
