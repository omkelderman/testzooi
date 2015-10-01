package com.github.omkelderman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by Olle on 2015-10-01.
 */
public class ResourceProvider implements IResourceProvider {

    @Override
    public BufferedReader getReaderForPath(String path) throws IOException {
        URL url = new URL(path);
        return new BufferedReader(new InputStreamReader(url.openStream()));
    }
}
