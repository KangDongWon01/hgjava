package com.yedam.interfaces;

public class OracleDB implements DAO {
	
	@Override
//	public void add() {
	public void insert() {
		System.out.println("[Oracle] 입력.");
	}
	@Override
//	public void modify() {
	public void update() {
		System.out.println("[Oracle] 수정.");
	}
	@Override
//	public void remove() {
	public void delete() {
		System.out.println("[Oracle] 삭제.");
	}
	
}
