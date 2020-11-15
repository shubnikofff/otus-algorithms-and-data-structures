package ru.otus;

import java.util.List;

public abstract class AbstractBits implements Testable<Integer, Result> {

	@Override
	public Integer getArguments(List<String> input) {
		return Integer.parseInt(input.get(0));
	}

	@Override
	public Result getExpectedResult(List<String> output) {
		return new Result(Integer.parseInt(output.get(0)), Long.parseLong(output.get(1)));
	}
}
