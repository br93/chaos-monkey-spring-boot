# Chaos Experiments

These experiments will add artificial exceptions to the API, affecting the database connectivity, with the objective of testing the resilience of the API, based on the concepts of Chaos Engineering.

## End-point being tested
- v1/produtos

## Setting virtual environment in python
```console
python3 -m venv ~/.venvs/chaostk
source  ~/.venvs/chaostk/bin/activate
pip install -U chaostoolkit
pip install -U chaostoolkit-spring
```

## Running the experiment (automation)
```console
chaos run path_to_experiments.json
```
