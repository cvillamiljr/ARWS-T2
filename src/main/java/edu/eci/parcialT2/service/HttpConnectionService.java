package edu.eci.parcialT2.service;

import java.io.IOException;

public interface HttpConnectionService {
     String weatherByCity(String name) throws IOException;
}
