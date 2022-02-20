using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace lb5
{
    public partial class MainForm : Form
    {
        
        public MainForm()
        {
            InitializeComponent();
        }

        private void MainForm_Load(object sender, EventArgs e)
        {

        }

        private void MainForm_MouseClick(object sender, MouseEventArgs e)
        {
            Button btn = new Button();
            int i;
            Random x = new Random();
            Point pt = new Point(int.Parse(x.Next(400).ToString()), int.Parse(x.Next(250).ToString()));
            btn.Location = pt;
            //MainForm frm = new MainForm();
            //
            ////  Location = e.Location;
            ////  Visible = true;
            //btn.Location = new Point(40, 20);

            //btn.Visible = true;
        }

        private void btn_Click(object sender, EventArgs e)
        {
            //Random x = new Random();
            //Point pt = new Point(int.Parse(x.Next(400).ToString()), int.Parse(x.Next(250).ToString()));
            //btn.Location = pt;
            MessageBox.Show("molodec");
        }

        private void btn_MouseEnter(object sender, EventArgs e)
        {
            Random x = new Random();
            Point pt = new Point(int.Parse(x.Next(400).ToString()), int.Parse(x.Next(250).ToString()));
            btn.Location = pt;
        }
    }
}
