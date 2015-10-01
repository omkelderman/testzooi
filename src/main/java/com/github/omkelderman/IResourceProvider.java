package com.github.omkelderman;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Created by Olle on 2015-10-01.
 */
public interface IResourceProvider {
    public BufferedReader getReaderForPath(String path) throws IOException;
}
