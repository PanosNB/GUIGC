FROM ibmjava:8-sdk

RUN mkdir /vol
VOLUME /vol

COPY jfxrt.jar /opt/ibm/java/jre/lib
COPY libprism_es2.so /opt/ibm/java/jre/lib/amd64

RUN apt-get update
RUN apt-get upgrade -y
RUN apt-get install -y  software-properties-common
RUN add-apt-repository ppa:webupd8team/java -y
RUN apt-get install libwebkit2gtk-3.0-25 -y
RUN apt-get install fonts-freefont-ttf -y
RUN apt-get install libasound2 -y
RUN apt-get install libgtk-3-dev -y
RUN apt-get install libswt-gtk-3-java -y
RUN apt-get update
RUN apt-get clean

COPY *.so /opt/ibm/java/jre/lib/amd64/
 
# cd to vol
CMD cd /vol && java GUIGCBench
