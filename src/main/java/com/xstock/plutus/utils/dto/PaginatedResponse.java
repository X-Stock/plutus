package com.xstock.plutus.utils.dto;

import java.util.List;

public record PaginatedResponse<T>(int totalPages, List<T> content) {}