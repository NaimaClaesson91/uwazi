FROM alpine

ENTRYPOINT \
  echo "Writing a file to the workspace to generate a diff"; \
  echo "New file" > newfile;
