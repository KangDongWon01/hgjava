package Board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Board {
	Scanner scan = new Scanner(System.in);
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	String inputID2 = null;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	BoardDAO bd = new BoardDAO();
	
	ArrayList<User> userlist = new ArrayList<User>(); // 회원(회원가입 한) 유저 리스트
	ArrayList<Article> articlelist = new ArrayList<Article>(); // 게시글 리스트

	boolean LoginState = false; // 로그인상태 - false: 로그아웃 true: 로그인
	int Joincont; // 회원가입 완료 시 유저(사람) 증가 카운트
	int Postwritecont; // 게시글 갯수 카운트
	
	String inputIDcheck; // 작성자를 출력하기 위한 변수

	public void start() throws SQLException {
		System.out.println("==========================================");
		System.out.println("|<<       게시판 프로그램을 실행합니다.       >>|");
		System.out.println("==========================================");
		System.out.println("|회원가입: 1 ||로그인: 2 ||로그아웃: 3 ||종료: 4|");
		System.out.println("------------------------------------------");
		System.out.println("|작성하기: 5 ||글수정: 6 ||삭제하기: 7 ||BY 예담|");
		System.out.println("------------------------------------------");
		System.out.println("|목록조회 : list || 게시글 내용확인 : showlist |");
		System.out.println("------------------------------------------");
		System.out.println("|             도움말 : showhelp            |");
		System.out.println("------------------------------------------");
		System.out.print("입력 >> ");
		

		while (true) {
			String command = scan.nextLine();

			if (command.equals("1")) { // 회원가입
				join();
			} else if (command.equals("2")) { // 로그인
				login();
			} else if (command.equals("3")) { // 로그아웃
				logOut();
			} else if (command.equals("5")) { // 게시글 쓰기
				Postadd();
			} else if (command.equals("6")) { // 게시글 수정
				PostChange();
			} else if (command.equals("7")) { // 게시글 삭제
				PostDelet();
			} else if (command.equals("list")) { // 게시글 목록
				Postlist();
			} else if (command.equals("showlist")) { // 게시물 상세보기
				Showpost();
			} else if (command.equals("showhelp")) { // 도움말 명령어
				Showhelp();
			} else if (command.equals("4")) { // 프로그램 종료
				System.out.println("<< 게시판 프로그램을 종료합니다. >>");
				scan.close();
				System.exit(0);
				break;
			} else {
				System.out.println("일치하는 명령어가 없습니다.");
				System.out.print("입력 >> ");
			}
		}
	}

	public void join() throws SQLException { // 회원가입
		conn = BoardDAO.getConn();
		System.out.println("<< 회원가입을 진행 합니다 >>");
		System.out.print("아이디를 입력하세요 : ");
		String inputID = scan.next();
		System.out.print("비밀번호를 입력하세요 : ");
		String inputPW = scan.next();
		System.out.print("이름 또는 닉네임을 입력하세요 : ");
		String inputName = scan.next();
		sql = "insert into b_user (id, pw, nicname) values(?, ?, ?)";
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, inputID);
		psmt.setString(2, inputPW);
		psmt.setString(3, inputName);
		int r = psmt.executeUpdate();
		if(r > 0) {
			Joincont++; // 회원가입이 정상적으로 완료되면 사람 수 카운트함.
			System.out.println(inputName + " 회원가입이 완료되었습니다.");
			System.out.print("입력 >> " + scan.nextLine());
		} else {
			System.out.println("회원가입이 정상적으로 처리되지 못했습니다.");
			return;
		}
		BoardDAO.disconn();
	}

	public void login() throws SQLException { // 로그인
		if (LoginState == true) {
			System.out.println("이미 로그인 상태 입니다.");
			System.out.print("입력 >> " + scan.nextLine());
		} else {
			conn = BoardDAO.getConn();
			System.out.println("<< 로그인을 진행합니다 >>");
			
			System.out.print("ID : ");
			inputID2 = scan.next();
			System.out.print("password : ");
			String inputPW2 = scan.next();
			
			inputIDcheck = inputID2; // 글 게시판에 작성자를 출력하기 위해 로그인한 ID값을 작성자 출력 변수에 값을 넣음.
			
			sql = "select id, pw from b_user where id = ? and pw = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, inputID2);
			psmt.setString(2, inputPW2);
			rs = psmt.executeQuery();
			while(rs.next()) {		
				if(rs.getString("id").equals(inputID2) && rs.getString("pw").equals(inputPW2)) {
					LoginState = true;
					System.out.println("로그인 성공!");
					System.out.print("입력 >> " + scan.nextLine());
					return;
				} else {
					System.out.print("아이디와 비밀번호가 맞지 않습니다. 다시 로그인 해주세요");
					LoginState = false;
					System.out.print("입력 >> " + scan.nextLine());
					return;
				}
			}
		}
		BoardDAO.disconn();
	}

	public void logOut() { // 로그아웃
		if (LoginState == false) {
			System.out.println("이미 로그아웃 상태입니다.");
			System.out.print("입력 >> " + scan.nextLine());
		} else {
			System.out.print("정상적으로 로그아웃 되었습니다.");
			LoginState = false;
			System.out.print("입력 >> " + scan.nextLine());
		}
	}

	public void Postadd() throws SQLException { // 게시글 추가
		if (LoginState == false) {
			System.out.println("권한이 없습니다.");
			System.out.print("입력 >> " + scan.nextLine());
		} else {
				conn = BoardDAO.getConn();
				System.out.println("<< 추가 할 게시글의 제목과 내용을 입력하세요 >>");

				System.out.print("제목 : ");
				String title = scan.next();
						
				System.out.print("내용 : ");
				String body = scan.next();
					
				Postwritecont++;      
				sql = "insert into article(no, title, body, postdate, writename) values (postnum.nextval,?,?, SYSDATE, ?)";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, title);
				psmt.setString(2, body);
				psmt.setString(3, inputID2);
				int r = psmt.executeUpdate();
				if(r > 0) {
					System.out.println(Postwritecont + "번째 글이 추가되었습니다.");
					System.out.print("입력 >> " + scan.nextLine());
				} else {
					System.out.println("게시글 등록에 실패하였습니다.");
					return;
				}
				BoardDAO.disconn();
				}
				
	}

	public void PostChange() throws SQLException { // 게시글 수정
		conn = BoardDAO.getConn();
		if (LoginState == false) {
			System.out.println("권한이 없습니다.");
			System.out.print("입력 >> " + scan.nextLine());
		} else if (Postwritecont == 0) {
			System.out.println("게시글이 존재 하지 않습니다.");
			System.out.print("입력 >> " + scan.nextLine());
		} else {
			while (true) {
					System.out.println("<< 수정할 게시글의 번호를 입력하세요 >>");
					int postnum4 = scan.nextInt();
					scan.nextLine();
					sql = "select no from article where no = ?";
					psmt = conn.prepareStatement(sql);
					psmt.setInt(1, postnum4);
					rs = psmt.executeQuery();
					if (rs.next()) {
						System.out.println("수정할 제목을 입력하세요. >> ");
						String postTitle = scan.nextLine();
						System.out.println("수정할 내용을 입력하세요. >> ");
						String postBody = scan.nextLine();	
						sql = "update article set title = ?, body = ? where postnum = ?";
						psmt = conn.prepareStatement(sql);
						psmt.setString(1, postTitle);
						psmt.setString(2, postBody);
						psmt.setInt(3, postnum4);
						System.out.println("수정에 성공하였습니다.");
					} else {
						System.out.println("수정에 실패하였습니다.");
					}
				}
			}
		BoardDAO.disconn();
		}

	public void PostDelet() throws SQLException { // 게시글 삭제
		conn = BoardDAO.getConn();
		if (LoginState == false) {
			System.out.println("권한이 없습니다.");
			System.out.print("입력 >> " + scan.nextLine());
		} else if (Postwritecont == 0) {
			System.out.println("게시글이 존재 하지 않습니다.");
			System.out.print("입력 >> " + scan.nextLine());
		} else {
			while (true) {
				System.out.println("<< 삭제할 게시글의 번호를 입력하세요 >>");
				int postnum3 = scan.nextInt();
				scan.nextLine();
				sql = "select no from article where no = ?";
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, postnum3);
				rs = psmt.executeQuery();
				if (rs.next()) {
					System.out.println("수정할 제목을 입력하세요. >> ");
					String postTitle = scan.nextLine();
					System.out.println("수정할 내용을 입력하세요. >> ");
					String postBody = scan.nextLine();	
					sql = "delete article set title = ?, body = ? where postnum = ?";
					psmt = conn.prepareStatement(sql);
					psmt.setString(1, postTitle);
					psmt.setString(2, postBody);
					psmt.setInt(3, postnum3);
					System.out.println("삭제를 성공하였습니다.");
				} else {
					System.out.println("삭제를 실패하였습니다.");
				}
			}
		}
	BoardDAO.disconn();
	}

	public void Postlist() throws SQLException { // 게시글 목록(리스트) 간략하게 출력 ( 게시글 번호, 제목, 날짜와 시간, 조회수, 좋아요, 작성자 출력 )
		conn = BoardDAO.getConn();
		if (Postwritecont == 0) {
			System.out.print("게시글이 존재 하지 않습니다.");
			System.out.print("입력 >> " + scan.nextLine());
		} else {
			System.out.println("<< 게시글 리스트 >>");
			System.out.println("번호    |   제목   |   작 성 시 간   |   조회수   |    좋아요    |    작성자");
			sql = "select no, title, postdate, writename  from article";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt("no") +"     "+ rs.getString("title") +"     "+ rs.getString("postdate") +"     "+ "집계 중." +"     "+ "집계 중." +"     "+ rs.getString("writename"));		
//				System.out.print("입력 >> " + scan.nextLine());
				}
			}
		BoardDAO.disconn();
	}

	public void Showpost() throws SQLException { // 게시글 상세보기 (게시글 번호, 제목, 내용, 날짜와 시간, 조회수, 좋아요, 작성자)
		conn = BoardDAO.getConn();
		if (Postwritecont == 0) { // Postwritecont 이 부분을 article 또는 articlelist로 조건을 줘도 됨 == null 로 줘야됨 0이 아닌..
			System.out.println("게시글이 존재 하지 않습니다.");
			System.out.print("입력 >> " + scan.nextLine());
		} else {
			System.out.println("<< 게시글 리스트 >>");
			System.out.println("번호    |   제목   |   작 성 시 간   |   조회수   |    좋아요    |    작성자");
			sql = "select no, title, postdate, writename  from article";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
			System.out.println(rs.getInt("no") +"     "+ rs.getString("title") +"     "+ rs.getString("postdate") +"     "+ "집계 중." +"     "+ "집계 중." +"     "+ rs.getString("writename"));		
			}
			
			for (;;) { // 바깥쪽
				try {
					System.out.println("<< 상세하게 볼 게시글 번호를 입력하세요 >>");
					int postnum2 = scan.nextInt();
					sql = "select no from article where no = ?";
					psmt = conn.prepareStatement(sql);
					psmt.setInt(1, postnum2);
					rs = psmt.executeQuery();
					if (rs.next()) {
						System.out.println( );
					}
					Article Showfound = null;

					for (int i = 0; i < articlelist.size(); i++) { 
						Article article = articlelist.get(i);
						
						if (LoginState == false) { // 로그아웃 상태일 때 게시글의 좋아요를 누를수 있는 기능을 수행하지 못하면서 로그아웃 상태에도 전체 게시글 목록을 봐야 할 때 // 바깥쪽
							if(article.getPostnum() == postnum2) { // 안쪽 if문
								Showfound = article;
								Showfound.IncreaseHit();
								System.out.println("번호: " + rs.getInt("no"));
								System.out.println("제목: " + rs.getString("title"));
								System.out.println("내용: " + rs.getString("body"));
								System.out.println("날짜와 시간: " + rs.getString("postdate"));
								System.out.println("조회수: " + Showfound.getHitCount());
								System.out.println("좋아요: " + Showfound.getLikeCount());
								System.out.println("작성자: " + rs.getString("writename"));
								System.out.print("로그인되지 않아 확인만 가능합니다." + scan.nextLine()); // 로그인을 하지 않고 로그아웃 상태일 때 좋아요를 못눌러야 되니까 명령어로 탈출
							}
						} else if (article.getPostnum() == postnum2) { // 로그인 상태일 때 // 바깥쪽 if문의 else if 문
							Showfound = article;
							Showfound.IncreaseHit();
							System.out.println("번호: " + rs.getInt("no"));
							System.out.println("제목: " + rs.getString("title"));
							System.out.println("내용: " + rs.getString("body"));
							System.out.println("날짜와 시간: " + rs.getString("postdate"));
							System.out.println("조회수: " + Showfound.getHitCount());
							System.out.println("좋아요: " + Showfound.getLikeCount());
							System.out.println("작성자: " + rs.getString("writename"));
							
							if(LoginState == true) { // 로그인을 해야지만 좋아요를 누를 수 있게 구현 (if문을 굳이 작성 안해도 else if문 자체에서 로그인 상태이니까.. 그냥 명확하게 알아보기 쉽게 작성..)
								System.out.println(rs.getInt("no") + " 번 게시글의 좋아요를 누르시겠습니까?");
								for (;;) { // 안쪽
									System.out.println("좋아요: Like or 돌아가기 : return");
									String likeorreturn = scan.next();
									if (likeorreturn.equals("Like")) {
										Showfound.IncreaseLike();
										System.out.println(rs.getInt("no") + " 번 게시글의 좋아요를 눌렀습니다.");
										System.out.print("입력 >> " + scan.nextLine()); // 바깥쪽 for문의 무한루프가 종료가 안되면 얘가 먼저 실행되면서
																						// 바로 밑에 코드인 break문이 안쪽 for문의 무한루프가
																						// 죵료가 되지만 바깥족 for문의 무한루프가 되면서 << 게시글 번호를 입력하세요 >>와 print 명령어 출력이 함께 실행이 됨.
										break; // 바깥쪽 for문의 무한루프를 끝내는게 아닌 이 해당되는 안쪽 for문의 무한루프가 종료 됨.
									} else if (likeorreturn.equals("return")) {
										System.out.print("입력 >> " + scan.nextLine()); // 위와 동일
										break; // 바깥쪽 for문의 무한루프를 끝내는게 아닌 이 해당되는 안쪽 for문의 무한루프가 종료 됨.
									} else {
										System.out.println("\"Like\" or \"return\" 만 입력해주세요."); // 이 실행 문장이 끝나고 안쪽 for문으로 가서 무한루프가 돌게 됨.
										//break; //break를 걸게 되면 Like or return을 계속 입력받아야 되는데 안쪽 for문의 무한루프가 끝나버려서 계속 입력받지 못하게 됨.
										         // 무한루프가 돌면서 System.out.println("좋아요: Like or 돌아가기 : return"); 이 문장이 계속 반복이 되야되는데
										         // break를 걸면 처음 1번만 출력되고 문장이 반복적으로 실행 되지 않고 끝나버림
									}
								}
							}
						}
					}

					if (Showfound == null) {
						System.out.println(postnum2 + "번 게시글은 존재하지 않습니다.");
						System.out.print("입력 >> " + scan.nextLine()); // 위 아래 설명과 동일
					}

					// 바깥쪽 for문의 무한루프 종료 시키기
					break; // Like or return 을 입력하거나 숫자로 입력했지만 게시글이 존재하지 않을 때 무한루프를 빠져나옴. 명령어가 실행 되는 이유는 바로
							// 위의 if문의 마지막 줄 명령어 코드가 실행되거나 안쪽 for문의 무한루프인 명령어 출력문이 실행되서..
							// 여기서 break를 안걸면 바로 위의 if문의 미자믹 줄인 print 명령어가 실행되면서 게시판 상세보기의 게시글 번호를 입력하세요.를
							// 입력하세요가 같이 실행이 됨.
							// 여기서 break를 안걸면 안쪽 for문의 무한루프인 명령어 출력문과 게시판 상세보기의 게시글 번호를 입력하세요.를 입력하세요가 같이
							// 실행이 됨.
				} catch (InputMismatchException ime) {
					System.out.println("게시글 번호(숫자)만 입력해주세요.");
					scan.next();
					continue; // 다른 타입이 아닌 정상적으로 계속 숫자(정수)로 입력될 때까지 무한루프 돌기 (continue문 안 써줘도 무한루프가 돌음)
					// break; -> 숫자(정수)가 아닌 다른 타입으로 입력했을 때 무한루프를 도는게 아닌 명령어로 바로 빠져나올 시
				}
			}

			// System.out.print("명령어 - " + scan.nextLine()); // -> 숫자(정수)가 아닌 다른 타입으로 입력했을 때 무한루프를 도는게 아닌 명령어로 바로 빠져나올 시
			// catch절에 break문이 실행되었을 때 무한루프가 종료되고 명령어가 바로 출력되는게 필요할 시에 사용함.
		} 
	}

	public void Showhelp() { // 도움말 명령어
		System.out.println("회원가입: 1  로그인: 2  로그아웃: 3  종료: 4");
		System.out.println("작성하기: 5  글수정: 6  삭제하기: 7  목록: list  상세보기: showlist");
		System.out.println("도움말 명령어: showhelp");
		System.out.print("입력 >> " + scan.nextLine());
	}
}