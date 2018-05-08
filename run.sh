#/bin/bash

for rep in 1 2 3 4 5 6 7 8
do
	for cpus in 1 2 4 8
	do
		for mem in 400 800 1600
		do
			for preset in A B C D
			do
				xmx=$((mem * 3 / 4))
				sudo docker run --cpus ${cpus} -m ${mem}MB -v /tmp/.X11-unix:/tmp/.X11-unix -v `pwd`:/vol -e DISPLAY=unix$DISPLAY -w /vol guigcj9 java -Xmx${xmx}m -Xgcpolicy:gencon -cp .:./jfxrt.jar GUIGCBench --autoRun=true --preset=$preset --asyncGCOnSleep=true > gc_gen.${rep}.${cpus}.${mem}.${preset}.txt

				sudo docker run --cpus ${cpus} -m ${mem}MB -v /tmp/.X11-unix:/tmp/.X11-unix -v `pwd`:/vol -e DISPLAY=unix$DISPLAY -w /vol guigcj9 java -Xmx${xmx}m -Xgcpolicy:balanced -cp .:./jfxrt.jar GUIGCBench --autoRun=true --preset=$preset --asyncGCOnSleep=true > gc_bal.${rep}.${cpus}.${mem}.${preset}.txt

				sudo docker run --cpus ${cpus} -m ${mem}MB -v /tmp/.X11-unix:/tmp/.X11-unix -v `pwd`:/vol -e DISPLAY=unix$DISPLAY -w /vol guigcj9 java -Xmx${xmx}m -Xgcpolicy:optthruput -cp .:./jfxrt.jar GUIGCBench --autoRun=true --preset=$preset --asyncGCOnSleep=true > gc_thr.${rep}.${cpus}.${mem}.${preset}.txt

				sudo docker run --cpus ${cpus} -m ${mem}MB -v /tmp/.X11-unix:/tmp/.X11-unix -v `pwd`:/vol -e DISPLAY=unix$DISPLAY -w /vol guigcj9 java -Xmx${xmx}m -Xgcpolicy:optavgpause -cp .:./jfxrt.jar GUIGCBench --autoRun=true --preset=$preset --asyncGCOnSleep=true > gc_pau.${rep}.${cpus}.${mem}.${preset}.txt
			done
		done
	done

done
