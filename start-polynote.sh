#!/bin/bash

docker run -p 8192:8192 -v `pwd`/polynote_notebooks:/usr/src/app/polynote/notebooks --name=polynote -d -t greglinscheid/polynote:latest
