NAMES := Main Tree Node TreeEnd TreeElement TraversalOrder BoxStall BoxerIn
SOURCEFILES := $(addsuffix .java, $(addprefix src/, $(NAMES)))
DISTFILES := $(addsuffix .class, $(addprefix dist/, $(NAMES)))

$(DISTFILES): $(SOURCEFILES)
	make clean && mkdir dist && javac $(SOURCEFILES) -cp src -d dist
clean:
	rm -rf dist
build: $(DISTFILES)
run: build
	java -cp dist/ Main