if ! command -v cookiecutter &>/dev/null; then
    echo "Error: cookiecutter is not installed"
    echo "Please install it with: brew install cookiecutter"
    exit 1
fi

if [ -z "$1" ]; then
    echo "Usage: $0 <template-path>"
    exit 1
fi

if [ ! -d "$1" ]; then
    echo "Error: template path does not exist"
    exit 1
fi

cookiecutter $1 \
    --no-input \
    --overwrite-if-exists \
    --output-dir . \
    shift_name=locally-generated-test-shift \
    owner=genai-migration-experiment \
    description="locally generated test shift"
